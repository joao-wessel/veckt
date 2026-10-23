package com.vectk.backend.service.document;

import com.vectk.backend.entity.Client;
import com.vectk.backend.entity.Project;
import com.vectk.backend.entity.Proposal;
import com.vectk.backend.entity.Tenant;
import com.vectk.backend.entity.TenantUser;
import java.time.LocalDate;

public record DocumentContext(
        Tenant tenant,
        Client client,
        Project project,
        Proposal proposal,
        TenantUser responsible,
        LocalDate currentDate
) {}
