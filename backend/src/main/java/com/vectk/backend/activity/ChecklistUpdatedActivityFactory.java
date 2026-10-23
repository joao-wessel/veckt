package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class ChecklistUpdatedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.CHECKLIST_UPDATED; }
    protected String defaultTitle() { return "Checklist atualizado"; }
}
