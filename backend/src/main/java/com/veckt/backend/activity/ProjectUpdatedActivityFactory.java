package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class ProjectUpdatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.PROJECT_UPDATED; }
    protected String defaultTitle() { return "Projeto atualizado"; }
}
