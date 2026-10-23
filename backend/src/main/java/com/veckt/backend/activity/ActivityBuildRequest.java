package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import com.veckt.backend.entity.ActivityVisibility;
import com.veckt.backend.entity.Project;
import com.veckt.backend.entity.Client;
import com.veckt.backend.entity.Proposal;
import com.veckt.backend.entity.GeneratedDocument;
import com.veckt.backend.entity.ProjectPhase;
import com.veckt.backend.entity.ProjectStage;
import com.veckt.backend.entity.Tenant;
import com.veckt.backend.entity.TenantUser;

public record ActivityBuildRequest(
        Tenant tenant,
        Project project,
        Client client,
        Proposal proposal,
        GeneratedDocument generatedDocument,
        ProjectPhase phase,
        ProjectStage stage,
        TenantUser author,
        String authorName,
        ActivityType type,
        ActivityVisibility visibility,
        String title,
        String description,
        String metadata
) {}
