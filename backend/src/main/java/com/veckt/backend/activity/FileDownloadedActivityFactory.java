package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileDownloadedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_DOWNLOADED; }
    protected String defaultTitle() { return "Arquivo baixado"; }
}
