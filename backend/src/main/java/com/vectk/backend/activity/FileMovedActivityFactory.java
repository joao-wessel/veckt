package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileMovedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_MOVED; }
    protected String defaultTitle() { return "Arquivo movido"; }
}
