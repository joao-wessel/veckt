package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class StatusChangedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.STATUS_CHANGED; }
    protected String defaultTitle() { return "Status alterado"; }
}
