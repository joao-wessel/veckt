package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class DocumentGeneratedActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.DOCUMENT_GENERATED; }
    protected String defaultTitle() { return "Documento gerado"; }
}
