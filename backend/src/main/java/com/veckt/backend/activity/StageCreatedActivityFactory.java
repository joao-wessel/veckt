package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class StageCreatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.STAGE_CREATED; }
    protected String defaultTitle() { return "Etapa criada"; }
}
