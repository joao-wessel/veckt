package com.vectk.backend.activity;

import com.vectk.backend.entity.Activity;
import com.vectk.backend.entity.ActivityType;

public interface ActivityFactory {
    ActivityType type();
    Activity build(ActivityBuildRequest request);
}
