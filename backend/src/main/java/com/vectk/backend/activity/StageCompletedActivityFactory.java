package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class StageCompletedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.STAGE_COMPLETED; }
    protected String defaultTitle() { return "Etapa concluída"; }
}
