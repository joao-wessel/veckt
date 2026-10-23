package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class UnassignmentActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.UNASSIGNED; }
    protected String defaultTitle() { return "Responsável removido"; }
}
