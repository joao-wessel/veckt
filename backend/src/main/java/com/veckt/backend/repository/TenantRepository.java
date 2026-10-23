package com.veckt.backend.repository;

import com.veckt.backend.entity.Tenant;
import com.veckt.backend.entity.TenantStatus;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, UUID> {
    long countByStatus(TenantStatus status);
    boolean existsByCnpj(String cnpj);
    Optional<Tenant> findByCnpj(String cnpj);
}
