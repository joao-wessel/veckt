package com.veckt.backend.repository;

import com.veckt.backend.entity.BriefingAttachment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BriefingAttachmentRepository extends JpaRepository<BriefingAttachment, UUID> {
    List<BriefingAttachment> findAllByBriefingIdAndTenantIdAndDeletedFalseOrderByCreatedAtDesc(UUID briefingId, UUID tenantId);
}
