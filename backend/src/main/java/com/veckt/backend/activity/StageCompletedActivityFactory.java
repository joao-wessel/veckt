package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class StageCompletedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.STAGE_COMPLETED; }
    protected String defaultTitle() { return "Etapa concluída"; }
}
