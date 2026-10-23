package com.veckt.backend.activity;

import com.veckt.backend.entity.ActivityType;
import org.springframework.stereotype.Component;

@Component
public class CommentActivityFactory extends AbstractActivityFactory {
    public ActivityType type() { return ActivityType.COMMENT; }
    protected String defaultTitle() { return "Comentário"; }
}
