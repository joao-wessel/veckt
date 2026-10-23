package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class SystemActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.SYSTEM; }
    protected String defaultTitle() { return "Atividade"; }
}
