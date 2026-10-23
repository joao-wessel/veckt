package com.vectk.backend.config;

public record InitialBootstrapProperties(
        boolean enabled,
        String adminName,
        String adminEmail,
        String adminPassword
) {}
