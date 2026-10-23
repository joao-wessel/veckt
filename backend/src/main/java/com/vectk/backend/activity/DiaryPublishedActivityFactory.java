package com.vectk.backend.activity;
import com.vectk.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class DiaryPublishedActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.DIARY_PUBLISHED;} protected String defaultTitle(){return "Registro publicado no Diário de Obra";} }
