package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class AssignmentActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.ASSIGNED; }
    protected String defaultTitle() { return "Responsável alterado"; }
}
