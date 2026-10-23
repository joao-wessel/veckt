package com.vectk.backend.controller;

import com.vectk.backend.dto.ApiResponse;
import com.vectk.backend.dto.AuthDtos.AuthResponse;
import com.vectk.backend.dto.AuthDtos.FirstAccessRequest;
import com.vectk.backend.dto.AuthDtos.ForgotPasswordRequest;
import com.vectk.backend.dto.AuthDtos.LoginRequest;
import com.vectk.backend.dto.AuthDtos.ResetPasswordRequest;
import com.vectk.backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/tenant")
public class TenantAuthController {
    private final AuthService authService;

    public TenantAuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ApiResponse.ok(authService.tenantLogin(request));
    }

    @PostMapping("/forgot-password")
    public ApiResponse<Void> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        authService.forgotPassword(request.email());
        return ApiResponse.message("Se o e-mail existir, enviaremos as instruções.");
    }

    @PostMapping("/reset-password")
    public ApiResponse<Void> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        authService.resetPassword(request.token(), request.password());
        return ApiResponse.message("Senha redefinida com sucesso.");
    }

    @PostMapping("/first-access")
    public ApiResponse<Void> firstAccess(@Valid @RequestBody FirstAccessRequest request) {
        authService.firstAccess(request.token(), request.password(), request.name());
        return ApiResponse.message("Senha definida com sucesso.");
    }
}
