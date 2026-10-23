package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class AssignmentActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.ASSIGNED; }
    protected String defaultTitle() { return "Responsável alterado"; }
}
