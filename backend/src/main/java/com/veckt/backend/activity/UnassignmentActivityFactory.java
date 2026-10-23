package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class UnassignmentActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.UNASSIGNED; }
    protected String defaultTitle() { return "Responsável removido"; }
}
