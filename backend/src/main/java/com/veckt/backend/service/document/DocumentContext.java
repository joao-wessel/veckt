package com.veckt.backend.service.document;

import com.veckt.backend.entity.Client;
import com.veckt.backend.entity.Project;
import com.veckt.backend.entity.Proposal;
import com.veckt.backend.entity.Tenant;
import com.veckt.backend.entity.TenantUser;
import java.time.LocalDate;

public record DocumentContext(
        Tenant tenant,
        Client client,
        Project project,
        Proposal proposal,
        TenantUser responsible,
        LocalDate currentDate
) {}
