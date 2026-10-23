package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class SystemActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.SYSTEM; }
    protected String defaultTitle() { return "Atividade"; }
}
