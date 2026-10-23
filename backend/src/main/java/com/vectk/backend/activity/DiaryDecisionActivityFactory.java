package com.vectk.backend.activity;
import com.vectk.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class DiaryDecisionActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.DIARY_DECISION_REGISTERED;} protected String defaultTitle(){return "Decisão registrada";} }
