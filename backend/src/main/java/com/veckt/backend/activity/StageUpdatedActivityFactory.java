package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class StageUpdatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.STAGE_UPDATED; }
    protected String defaultTitle() { return "Etapa atualizada"; }
}
