package com.veckt.backend.activity;
import com.veckt.backend.entity.ActivityType; import org.springframework.stereotype.Component;
@Component public class DiaryFileActivityFactory extends AbstractActivityFactory { public ActivityType type(){return ActivityType.DIARY_FILE_ADDED;} protected String defaultTitle(){return "Arquivo adicionado ao Diário";} }
