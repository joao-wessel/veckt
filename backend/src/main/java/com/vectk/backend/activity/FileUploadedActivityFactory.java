package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileUploadedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_UPLOADED; }
    protected String defaultTitle() { return "Arquivo enviado"; }
}
