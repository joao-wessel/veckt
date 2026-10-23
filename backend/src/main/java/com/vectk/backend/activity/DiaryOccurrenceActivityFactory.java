package com.vectk.backend.activity;
import com.vectk.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class DiaryOccurrenceActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.DIARY_OCCURRENCE_CREATED;} protected String defaultTitle(){return "Ocorrência registrada";} }
