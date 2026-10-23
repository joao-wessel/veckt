package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileRestoredActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_RESTORED; }
    protected String defaultTitle() { return "Arquivo restaurado"; }
}
