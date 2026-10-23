package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class ProjectCreatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.PROJECT_CREATED; }
    protected String defaultTitle() { return "Projeto criado"; }
}
