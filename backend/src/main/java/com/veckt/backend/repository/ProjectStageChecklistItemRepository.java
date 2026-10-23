package com.veckt.backend.repository;

import com.veckt.backend.entity.ProjectStageChecklistItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectStageChecklistItemRepository extends JpaRepository<ProjectStageChecklistItem, UUID> {
    List<ProjectStageChecklistItem> findAllByStageIdAndTenantIdAndDeletedFalseOrderByOrderAsc(UUID stageId, UUID tenantId);
    Optional<ProjectStageChecklistItem> findByIdAndTenantIdAndDeletedFalse(UUID id, UUID tenantId);
    long countByTenantIdAndCompletedFalseAndDeletedFalse(UUID tenantId);
    long countByStageIdAndTenantIdAndDeletedFalse(UUID stageId, UUID tenantId);
    long countByStageIdAndTenantIdAndCompletedTrueAndDeletedFalse(UUID stageId, UUID tenantId);
}
