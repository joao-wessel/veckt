package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileMovedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_MOVED; }
    protected String defaultTitle() { return "Arquivo movido"; }
}
