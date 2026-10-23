package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileRestoredActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_RESTORED; }
    protected String defaultTitle() { return "Arquivo restaurado"; }
}
