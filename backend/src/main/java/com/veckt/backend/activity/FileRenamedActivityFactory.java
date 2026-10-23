package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileRenamedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_RENAMED; }
    protected String defaultTitle() { return "Arquivo renomeado"; }
}
