package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import com.vectk.backend.entity.ActivityVisibility;
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
