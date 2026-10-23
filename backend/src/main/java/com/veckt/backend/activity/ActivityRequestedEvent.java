package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import com.veckt.backend.entity.ActivityVisibility;
import java.util.UUID;

public record ActivityRequestedEvent(
        UUID tenantId,
        UUID projectId,
        UUID clientId,
        UUID proposalId,
        UUID generatedDocumentId,
        UUID phaseId,
        UUID stageId,
        UUID authorId,
        String authorName,
        ActivityType type,
        ActivityVisibility visibility,
        String title,
        String description,
        String metadata
) {}
