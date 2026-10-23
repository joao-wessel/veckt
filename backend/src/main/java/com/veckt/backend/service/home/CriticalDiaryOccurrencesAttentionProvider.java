package com.veckt.backend.service.home;

import com.veckt.backend.dto.HomeDtos.AttentionItemResponse;
import com.veckt.backend.entity.ConstructionDiarySeverity;
import com.veckt.backend.repository.ConstructionDiaryOccurrenceRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CriticalDiaryOccurrencesAttentionProvider implements AttentionProvider {
    private final ConstructionDiaryOccurrenceRepository occurrences;
    public CriticalDiaryOccurrencesAttentionProvider(ConstructionDiaryOccurrenceRepository occurrences) { this.occurrences = occurrences; }
    public List<AttentionItemResponse> provide(HomeUserContext context) {
        return occurrences.findTopCriticalForHome(context.tenantId(), ConstructionDiarySeverity.CRITICAL).stream()
                .filter(occurrence -> HomeAccess.canSee(context, occurrence.getDiaryEntry().getProject())).limit(10)
                .map(occurrence -> new AttentionItemResponse("CRITICAL_DIARY_OCCURRENCE", "CRITICAL", "Ocorrência crítica", occurrence.getTitle(),
                        occurrence.getDiaryEntry().getProject().getId(), occurrence.getDiaryEntry().getProject().getName(), occurrence.getId(),
                        "/app/construction-diary/" + occurrence.getDiaryEntry().getId(), occurrence.getDueDate())).toList();
    }
}
