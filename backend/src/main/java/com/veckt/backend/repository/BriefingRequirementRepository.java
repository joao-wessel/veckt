package com.veckt.backend.repository;

import com.veckt.backend.entity.BriefingRequirement;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BriefingRequirementRepository extends JpaRepository<BriefingRequirement, UUID> {
    List<BriefingRequirement> findAllByBriefingIdAndTenantIdAndDeletedFalseOrderByOrderAsc(UUID briefingId, UUID tenantId);
}
