package com.vectk.backend.security;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "vectk.security")
public record SecurityProperties(@NotBlank @Size(min = 32) String platformSecret,
                                 @NotBlank @Size(min = 32) String tenantSecret,
                                 @NotBlank String issuer,
                                 long accessTokenMinutes) {
}
