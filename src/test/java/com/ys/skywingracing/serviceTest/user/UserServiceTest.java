package com.ys.skywingracing.serviceTest.user;

import com.ys.skywingracing.common.domain.exception.EntityNotFoundException;
import com.ys.skywingracing.user.application.dto.request.create.CreateUserRequestDto;
import com.ys.skywingracing.user.application.dto.request.update.UpdateRoleRequestDto;
import com.ys.skywingracing.user.application.dto.response.UserResponseDto;
import com.ys.skywingracing.user.application.mapper.UserMapper;
import com.ys.skywingracing.user.domain.enums.Role;
import com.ys.skywingracing.user.domain.exception.emailException.EmailAlreadyExistsException;
import com.ys.skywingracing.user.domain.exception.usernameException.UsernameAlreadyExistsException;
import com.ys.skywingracing.user.domain.model.User;
import com.ys.skywingracing.user.domain.objectValue.FullName;
import com.ys.skywingracing.user.domain.service.impl.UserDomainService;
import com.ys.skywingracing.user.infrastructure.repository.UserRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static final UUID USER_ID = UUID.randomUUID();
    private static final FullName NAME = new FullName("youssef", "hihi");
    private static final String EMAIL = "youssef@gmail.com";
    private static final String USERNAME = "sivak";
    private static final String PASSWORD = "password";

    @Mock
    private  UserRepository repository;

    @Mock
    private PasswordEncoder encoder;

    @Mock
    private  UserMapper mapper;


    @InjectMocks
    private UserDomainService userService;

    private User user;
    UserResponseDto expectedResponse;


    @BeforeEach
    public void setUp() {
        user = User.builder()
                .id(USER_ID)
                .email(EMAIL)
                .name(NAME)
                .password(encoder.encode(PASSWORD))
                .username(USERNAME)
                .role(Role.ROLE_USER)
                .build();
        expectedResponse = new UserResponseDto(USER_ID, EMAIL, NAME, USERNAME, Role.ROLE_USER);
    }

    @Nested
    class createUser {
        @Test
        void shouldCreateNewUserSuccessfully() {
            CreateUserRequestDto requestDto = new CreateUserRequestDto(USERNAME, EMAIL, NAME, PASSWORD);

            when(repository.existsByUsername(USERNAME)).thenReturn(false);
            when(repository.existsByEmail(EMAIL)).thenReturn(false);
            when(encoder.encode(PASSWORD)).thenReturn("encodedPassword");
            when(repository.save(any(User.class))).thenReturn(user);
            when(mapper.toResponseDto(user)).thenReturn(expectedResponse);

            UserResponseDto response = userService.saveUser(requestDto);

            assertNotNull(response);
            assertEquals(USERNAME, response.username());
            assertEquals(EMAIL, response.email());
            assertEquals(Role.ROLE_USER, response.role());

            verify(repository).existsByUsername(USERNAME);
            verify(repository).existsByEmail(EMAIL);
            verify(repository).save(any(User.class));
            verify(mapper).toResponseDto(user);
        }

        @Test
        void shouldThrowExceptionWhenUsernameExists() {
            CreateUserRequestDto requestDto = new CreateUserRequestDto(USERNAME, EMAIL, NAME, PASSWORD);

            when(repository.existsByUsername(USERNAME)).thenReturn(true);

            assertThrows(UsernameAlreadyExistsException.class, () -> userService.saveUser(requestDto));

            verify(repository, times(1)).existsByUsername(USERNAME);
        }

        @Test
        void shouldThrowExceptionWhenEmailExists() {
            CreateUserRequestDto requestDto = new CreateUserRequestDto(USERNAME, EMAIL, NAME, PASSWORD);

            when(repository.existsByUsername(USERNAME)).thenReturn(false);
            when(repository.existsByEmail(EMAIL)).thenReturn(true);

            assertThrows(EmailAlreadyExistsException.class, () -> userService.saveUser(requestDto));

            verify(repository ,times(1)).existsByUsername(USERNAME);
            verify(repository ,times(1)).existsByEmail(EMAIL);
        }

    }

    @Nested
    class UpdateUser {
        @Test
        void shouldUpdateUserRoleSuccessfully() {
            UpdateRoleRequestDto updateRoleRequestDto = new UpdateRoleRequestDto(USER_ID, Role.ROLE_ORGANIZER);
            UserResponseDto expectedResponse = new UserResponseDto(USER_ID, EMAIL, NAME, USERNAME, Role.ROLE_ORGANIZER);

            when(repository.findById(USER_ID)).thenReturn(Optional.of(user));
            user.setRole(Role.ROLE_ORGANIZER);
            when(repository.save(user)).thenReturn(user);
            when(mapper.toResponseDto(user)).thenReturn(expectedResponse);

            UserResponseDto responseDto = userService.updateRole(updateRoleRequestDto);

            assertNotNull(responseDto);
            assertEquals(expectedResponse, responseDto);
            assertEquals(Role.ROLE_ORGANIZER, responseDto.role());

            verify(repository, times(1)).findById(USER_ID);
            verify(repository, times(1)).save(user);
            verify(mapper, times(1)).toResponseDto(user);
        }

        @Test
        void shouldThrowEntityNotFoundExceptionWhenUserNotFound(){
            UpdateRoleRequestDto updateRoleRequestDto = new UpdateRoleRequestDto(USER_ID, Role.ROLE_ORGANIZER);

            when(repository.findById(USER_ID)).thenReturn(Optional.empty());

            assertThrows(EntityNotFoundException.class, () -> userService.updateRole(updateRoleRequestDto));

            verify(repository, times(1)).findById(USER_ID);
            verify(mapper, times(0)).toResponseDto(any(User.class));
        }
    }

}
