package com.vectk.backend.config;

import com.vectk.backend.service.InitialPlatformBootstrapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootstrapConfig {
    @Bean
    CommandLineRunner bootstrapInitialPlatformAdmin(InitialPlatformBootstrapService service,
                                             @Value("${vectk.initial-bootstrap.enabled:false}") boolean enabled,
                                             @Value("${vectk.initial-bootstrap.admin-name:}") String adminName,
                                             @Value("${vectk.initial-bootstrap.admin-email:}") String adminEmail,
                                             @Value("${vectk.initial-bootstrap.admin-password:}") String adminPassword) {
        return args -> service.bootstrap(new InitialBootstrapProperties(enabled, adminName, adminEmail, adminPassword));
    }
}
