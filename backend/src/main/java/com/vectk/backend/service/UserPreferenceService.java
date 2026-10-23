package com.vectk.backend.service;

import com.vectk.backend.dto.UserPreferenceDtos.AppearancePreferencesRequest;
import com.vectk.backend.dto.UserPreferenceDtos.AppearancePreferencesResponse;
import com.vectk.backend.exception.NotFoundException;
import com.vectk.backend.repository.PlatformUserRepository;
import com.vectk.backend.repository.TenantUserRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserPreferenceService {
    private final PlatformUserRepository platformUsers;
    private final TenantUserRepository tenantUsers;

    public UserPreferenceService(PlatformUserRepository platformUsers, TenantUserRepository tenantUsers) {
        this.platformUsers = platformUsers;
        this.tenantUsers = tenantUsers;
    }

    @Transactional(readOnly = true)
    public AppearancePreferencesResponse getPlatformPreferences(UUID userId) {
        var user = platformUsers.findById(userId).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
        return new AppearancePreferencesResponse(user.getThemeMode(), user.getColorPalette());
    }

    @Transactional
    public AppearancePreferencesResponse updatePlatformPreferences(UUID userId, AppearancePreferencesRequest request) {
        var user = platformUsers.findById(userId).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
        user.setThemeMode(request.themeMode());
        user.setColorPalette(request.colorPalette());
        return new AppearancePreferencesResponse(user.getThemeMode(), user.getColorPalette());
    }

    @Transactional(readOnly = true)
    public AppearancePreferencesResponse getTenantPreferences(UUID userId) {
        var user = tenantUsers.findById(userId).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
        return new AppearancePreferencesResponse(user.getThemeMode(), user.getColorPalette());
    }

    @Transactional
    public AppearancePreferencesResponse updateTenantPreferences(UUID userId, AppearancePreferencesRequest request) {
        var user = tenantUsers.findById(userId).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
        user.setThemeMode(request.themeMode());
        user.setColorPalette(request.colorPalette());
        return new AppearancePreferencesResponse(user.getThemeMode(), user.getColorPalette());
    }
}
