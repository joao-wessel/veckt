package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class FileVersionedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.FILE_VERSIONED; }
    protected String defaultTitle() { return "Nova versão de arquivo"; }
}
