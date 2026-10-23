package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class StageCreatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.STAGE_CREATED; }
    protected String defaultTitle() { return "Etapa criada"; }
}
