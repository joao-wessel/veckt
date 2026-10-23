package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class ProjectCompletedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.PROJECT_COMPLETED; }
    protected String defaultTitle() { return "Projeto concluído"; }
}
