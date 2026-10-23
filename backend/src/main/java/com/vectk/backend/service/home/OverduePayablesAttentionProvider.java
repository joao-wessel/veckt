package com.vectk.backend.service.home;

import com.vectk.backend.entity.FinancialEntryType;
import com.vectk.backend.repository.FinancialInstallmentRepository;
import org.springframework.stereotype.Component;

@Component
public class OverduePayablesAttentionProvider extends AbstractOverdueFinancialAttentionProvider {
    public OverduePayablesAttentionProvider(FinancialInstallmentRepository installments) {
        super(installments, FinancialEntryType.PAYABLE, "OVERDUE_PAYABLE", "Conta a pagar vencida");
    }
}
