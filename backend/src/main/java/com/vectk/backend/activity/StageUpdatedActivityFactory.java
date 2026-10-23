package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class StageUpdatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.STAGE_UPDATED; }
    protected String defaultTitle() { return "Etapa atualizada"; }
}
