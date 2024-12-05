package com.ys.skywingracing.user.api;


import com.ys.skywingracing.user.application.dto.request.update.UpdateRoleRequestDto;
import com.ys.skywingracing.user.application.dto.response.UserResponseDto;
import com.ys.skywingracing.user.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/private")
public class userController {

    private final UserService service;

    @PatchMapping("/admin/user-role")
    public ResponseEntity<UserResponseDto> updateUserRole(@Valid @RequestBody UpdateRoleRequestDto updateRoleRequestDto) {
        UserResponseDto userUpdated = service.updateRole(updateRoleRequestDto);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

}
