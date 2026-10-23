package com.veckt.backend.service.home;

import com.veckt.backend.entity.Project;
import com.veckt.backend.entity.ProjectStage;

final class HomeAccess {
    private HomeAccess() {}

    static boolean canSee(HomeUserContext context, Project project) {
        return context.isTenantAdmin()
                || same(context, project.getResponsibleUser())
                || same(context, project.getProjectManager());
    }

    static boolean canSee(HomeUserContext context, ProjectStage stage) {
        return canSee(context, stage.getProjectPhase().getProject()) || same(context, stage.getResponsibleUser());
    }

    private static boolean same(HomeUserContext context, com.veckt.backend.entity.TenantUser user) {
        return user != null && context.userId().equals(user.getId());
    }
}
