package com.vectk.backend.service.home;

import com.vectk.backend.dto.HomeDtos.AttentionItemResponse;
import com.vectk.backend.entity.ApprovalStatus;
import com.vectk.backend.repository.ApprovalRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ExpiringApprovalsAttentionProvider implements AttentionProvider {
    private final ApprovalRepository approvals;
    public ExpiringApprovalsAttentionProvider(ApprovalRepository approvals) { this.approvals = approvals; }
    public List<AttentionItemResponse> provide(HomeUserContext context) {
        LocalDate today = LocalDate.now();
        return approvals.findAllByTenantIdAndDeletedFalseAndDeadlineBetween(context.tenantId(), today, today.plusDays(2)).stream()
                .filter(approval -> approval.getStatus() == ApprovalStatus.PENDING).filter(approval -> HomeAccess.canSee(context, approval.getProject())).limit(10)
                .map(approval -> new AttentionItemResponse("EXPIRING_APPROVAL", "NORMAL", "Aprovação próxima do vencimento", approval.getDescription(),
                        approval.getProject().getId(), approval.getProject().getName(), approval.getId(),
                        "/app/projects/" + approval.getProject().getId() + "/approvals/" + approval.getId(), approval.getDeadline())).toList();
    }
}
