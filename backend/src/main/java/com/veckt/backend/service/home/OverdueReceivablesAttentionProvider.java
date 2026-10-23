package com.veckt.backend.service.home;

import com.veckt.backend.entity.FinancialEntryType;
import com.veckt.backend.repository.FinancialInstallmentRepository;
import org.springframework.stereotype.Component;

@Component
public class OverdueReceivablesAttentionProvider extends AbstractOverdueFinancialAttentionProvider {
    public OverdueReceivablesAttentionProvider(FinancialInstallmentRepository installments) {
        super(installments, FinancialEntryType.RECEIVABLE, "OVERDUE_RECEIVABLE", "Conta a receber vencida");
    }
}
