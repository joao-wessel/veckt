package com.vectk.backend.activity;
import com.vectk.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class DiaryFileActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.DIARY_FILE_ADDED;} protected String defaultTitle(){return "Arquivo adicionado ao Diário";} }
