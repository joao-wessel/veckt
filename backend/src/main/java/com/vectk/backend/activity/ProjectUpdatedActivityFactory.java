package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class ProjectUpdatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.PROJECT_UPDATED; }
    protected String defaultTitle() { return "Projeto atualizado"; }
}
