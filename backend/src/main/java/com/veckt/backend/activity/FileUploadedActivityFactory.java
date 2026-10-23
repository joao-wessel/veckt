package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileUploadedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_UPLOADED; }
    protected String defaultTitle() { return "Arquivo enviado"; }
}
