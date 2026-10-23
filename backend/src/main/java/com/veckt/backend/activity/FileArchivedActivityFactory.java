package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileArchivedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_ARCHIVED; }
    protected String defaultTitle() { return "Arquivo arquivado"; }
}
