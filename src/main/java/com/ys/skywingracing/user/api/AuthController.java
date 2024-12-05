package com.ys.skywingracing.user.api;

import com.ys.skywingracing.user.application.dto.request.create.CreateUserRequestDto;
import com.ys.skywingracing.user.application.dto.response.UserResponseDto;
import com.ys.skywingracing.user.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/public")
public class AuthController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody CreateUserRequestDto request) {
        UserResponseDto user = service.saveUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }



}
