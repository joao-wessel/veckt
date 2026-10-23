package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class PhaseCreatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.PHASE_CREATED; }
    protected String defaultTitle() { return "Fase criada"; }
}
