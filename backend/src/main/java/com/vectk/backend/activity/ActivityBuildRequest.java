package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import com.vectk.backend.entity.ActivityVisibility;
import com.vectk.backend.entity.Project;
import com.vectk.backend.entity.Client;
import com.vectk.backend.entity.Proposal;
import com.vectk.backend.entity.GeneratedDocument;
import com.vectk.backend.entity.ProjectPhase;
import com.vectk.backend.entity.ProjectStage;
import com.vectk.backend.entity.Tenant;
import com.vectk.backend.entity.TenantUser;

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
