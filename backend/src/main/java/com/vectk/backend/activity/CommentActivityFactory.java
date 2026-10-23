package com.vectk.backend.activity;

import com.vectk.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class CommentActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.COMMENT; }
    protected String defaultTitle() { return "Comentário"; }
}
