package com.veckt.backend.activity;
import com.veckt.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class DiaryCreatedActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.DIARY_CREATED;} protected String defaultTitle(){return "Diário de Obra iniciado";} }
