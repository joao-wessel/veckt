package com.vectk.backend.activity;
import com.vectk.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class DiaryUpdatedActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.DIARY_UPDATED;} protected String defaultTitle(){return "Diário de Obra atualizado";} }
