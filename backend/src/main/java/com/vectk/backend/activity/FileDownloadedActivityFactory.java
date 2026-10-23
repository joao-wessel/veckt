package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileDownloadedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_DOWNLOADED; }
    protected String defaultTitle() { return "Arquivo baixado"; }
}
