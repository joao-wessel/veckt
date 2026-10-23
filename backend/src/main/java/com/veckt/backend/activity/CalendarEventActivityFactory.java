package com.veckt.backend.activity;
import com.veckt.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class CalendarEventActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.CALENDAR_EVENT_CREATED;} protected String defaultTitle(){return "Compromisso criado";} }
