package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class PhaseUpdatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.PHASE_UPDATED; }
    protected String defaultTitle() { return "Fase atualizada"; }
}
