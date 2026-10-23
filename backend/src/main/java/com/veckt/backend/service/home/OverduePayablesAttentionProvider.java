package com.veckt.backend.service.home;

import com.veckt.backend.entity.FinancialEntryType;
import com.veckt.backend.repository.FinancialInstallmentRepository;
import org.springframework.stereotype.Component;

@Component
public class OverduePayablesAttentionProvider extends AbstractOverdueFinancialAttentionProvider {
    public OverduePayablesAttentionProvider(FinancialInstallmentRepository installments) {
        super(installments, FinancialEntryType.PAYABLE, "OVERDUE_PAYABLE", "Conta a pagar vencida");
    }
}
