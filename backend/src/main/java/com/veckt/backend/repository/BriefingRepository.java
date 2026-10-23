package com.veckt.backend.repository;

import com.veckt.backend.entity.Briefing;
import com.veckt.backend.entity.BriefingStatus;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BriefingRepository extends JpaRepository<Briefing, UUID>, JpaSpecificationExecutor<Briefing> {
    Optional<Briefing> findByIdAndTenantIdAndDeletedFalse(UUID id, UUID tenantId);
    long countByTenantIdAndStatusAndDeletedFalse(UUID tenantId, BriefingStatus status);
}
