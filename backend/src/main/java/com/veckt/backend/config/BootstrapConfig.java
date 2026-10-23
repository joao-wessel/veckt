package com.veckt.backend.config;

import com.veckt.backend.service.InitialPlatformBootstrapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootstrapConfig {
    @Bean
    CommandLineRunner bootstrapInitialPlatformAdmin(InitialPlatformBootstrapService service,
                                             @Value("${veckt.initial-bootstrap.enabled:false}") boolean enabled,
                                             @Value("${veckt.initial-bootstrap.admin-name:}") String adminName,
                                             @Value("${veckt.initial-bootstrap.admin-email:}") String adminEmail,
                                             @Value("${veckt.initial-bootstrap.admin-password:}") String adminPassword) {
        return args -> service.bootstrap(new InitialBootstrapProperties(enabled, adminName, adminEmail, adminPassword));
    }
}
