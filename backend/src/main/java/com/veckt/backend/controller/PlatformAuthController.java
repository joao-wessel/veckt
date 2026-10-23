package com.veckt.backend.controller;

import com.veckt.backend.dto.ApiResponse;
import com.veckt.backend.dto.AuthDtos.AuthResponse;
import com.veckt.backend.dto.AuthDtos.ForgotPasswordRequest;
import com.veckt.backend.dto.AuthDtos.LoginRequest;
import com.veckt.backend.dto.AuthDtos.ResetPasswordRequest;
import com.veckt.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/platform")
public class PlatformAuthController {
    private final AuthService authService;

    public PlatformAuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ApiResponse.ok(authService.platformLogin(request));
    }

    @PostMapping("/forgot-password")
    public ApiResponse<Void> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        authService.forgotPlatformPassword(request.email());
        return ApiResponse.message("Se o e-mail existir, enviaremos as instruções.");
    }

    @PostMapping("/reset-password")
    public ApiResponse<Void> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        authService.resetPlatformPassword(request.token(), request.password());
        return ApiResponse.message("Senha redefinida com sucesso.");
    }
}
