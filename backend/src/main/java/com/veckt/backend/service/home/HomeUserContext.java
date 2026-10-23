package com.veckt.backend.service.home;

import com.veckt.backend.entity.Role;
import java.util.Set;
import java.util.UUID;

public record HomeUserContext(UUID tenantId, UUID userId, Set<Role> roles) {
    public boolean isTenantAdmin() {
        return roles.contains(Role.ROLE_TENANT_ADMIN);
    }
}
