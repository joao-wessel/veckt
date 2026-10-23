package com.vectk.backend.service.home;

import com.vectk.backend.dto.HomeDtos.AttentionItemResponse;
import com.vectk.backend.entity.ApprovalStatus;
import com.vectk.backend.repository.ApprovalRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PendingApprovalsAttentionProvider implements AttentionProvider {
    private final ApprovalRepository approvals;
    public PendingApprovalsAttentionProvider(ApprovalRepository approvals) { this.approvals = approvals; }
    public List<AttentionItemResponse> provide(HomeUserContext context) {
        return approvals.findTop20ByTenantIdAndStatusAndDeletedFalseOrderByDeadlineAsc(context.tenantId(), ApprovalStatus.PENDING).stream()
                .filter(approval -> HomeAccess.canSee(context, approval.getProject())).limit(10)
                .map(approval -> new AttentionItemResponse("PENDING_APPROVAL", "HIGH", "Aprovação pendente", approval.getDescription(),
                        approval.getProject().getId(), approval.getProject().getName(), approval.getId(),
                        "/app/projects/" + approval.getProject().getId() + "/approvals/" + approval.getId(), approval.getDeadline())).toList();
    }
}
