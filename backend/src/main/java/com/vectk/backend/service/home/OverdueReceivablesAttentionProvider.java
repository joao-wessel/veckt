package com.vectk.backend.service.home;

import com.vectk.backend.entity.FinancialEntryType;
import com.vectk.backend.repository.FinancialInstallmentRepository;
import org.springframework.stereotype.Component;

@Component
public class OverdueReceivablesAttentionProvider extends AbstractOverdueFinancialAttentionProvider {
    public OverdueReceivablesAttentionProvider(FinancialInstallmentRepository installments) {
        super(installments, FinancialEntryType.RECEIVABLE, "OVERDUE_RECEIVABLE", "Conta a receber vencida");
    }
}
