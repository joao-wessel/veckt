package com.veckt.backend.activity;
import com.veckt.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class DiaryOccurrenceActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.DIARY_OCCURRENCE_CREATED;} protected String defaultTitle(){return "Ocorrência registrada";} }
