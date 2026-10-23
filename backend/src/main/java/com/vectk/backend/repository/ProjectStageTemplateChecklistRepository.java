package com.vectk.backend.repository;

import com.vectk.backend.entity.ProjectStageTemplateChecklist;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectStageTemplateChecklistRepository extends JpaRepository<ProjectStageTemplateChecklist, UUID> {
    List<ProjectStageTemplateChecklist> findAllByStageTemplateIdAndTenantIdAndDeletedFalseOrderByOrderAsc(UUID stageTemplateId, UUID tenantId);
}
