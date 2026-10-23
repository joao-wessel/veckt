package com.veckt.backend.activity;

import com.veckt.backend.entity.Activity;
import com.veckt.backend.entity.ActivityType;

public interface ActivityFactory {
    ActivityType type();
    Activity build(ActivityBuildRequest request);
}
