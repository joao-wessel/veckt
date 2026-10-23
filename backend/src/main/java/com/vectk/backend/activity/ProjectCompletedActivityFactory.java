package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class ProjectCompletedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.PROJECT_COMPLETED; }
    protected String defaultTitle() { return "Projeto concluído"; }
}
