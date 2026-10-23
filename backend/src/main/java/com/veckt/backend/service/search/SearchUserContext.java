package com.veckt.backend.service.search;

import com.veckt.backend.entity.Role;
import java.util.Set;
import java.util.UUID;

public record SearchUserContext(UUID tenantId, UUID userId, Set<Role> roles) {
    public boolean isTenantAdmin() { return roles.contains(Role.ROLE_TENANT_ADMIN); }
}
