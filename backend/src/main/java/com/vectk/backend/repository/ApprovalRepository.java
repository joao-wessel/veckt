package com.vectk.backend.repository;

import com.vectk.backend.entity.Approval;
import com.vectk.backend.entity.ApprovalStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<Approval, UUID> {
    Optional<Approval> findByIdAndTenantIdAndDeletedFalse(UUID id, UUID tenantId);
    List<Approval> findAllByProjectIdAndTenantIdAndDeletedFalseOrderByCreatedAtDesc(UUID projectId, UUID tenantId);
    List<Approval> findAllByClientIdAndTenantIdAndDeletedFalseOrderByCreatedAtDesc(UUID clientId, UUID tenantId);
    long countByClientIdAndTenantIdAndStatusAndDeletedFalse(UUID clientId, UUID tenantId, ApprovalStatus status);
    @org.springframework.data.jpa.repository.EntityGraph(attributePaths = {"project", "project.responsibleUser", "project.projectManager", "stage", "stage.responsibleUser"})
    List<Approval> findAllByTenantIdAndDeletedFalseAndDeadlineBetween(UUID tenantId, LocalDate start, LocalDate end);
    @org.springframework.data.jpa.repository.EntityGraph(attributePaths = {"project", "project.responsibleUser", "project.projectManager", "stage", "stage.responsibleUser"})
    List<Approval> findTop20ByTenantIdAndStatusAndDeletedFalseOrderByDeadlineAsc(UUID tenantId, ApprovalStatus status);
}
