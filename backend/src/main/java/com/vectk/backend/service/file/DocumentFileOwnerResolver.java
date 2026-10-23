package com.vectk.backend.service.file;

import com.vectk.backend.entity.FileOwnerType;
import com.vectk.backend.exception.NotFoundException;
import com.vectk.backend.repository.GeneratedDocumentRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class DocumentFileOwnerResolver implements FileOwnerResolver {
    private final GeneratedDocumentRepository repository;
    public DocumentFileOwnerResolver(GeneratedDocumentRepository repository) { this.repository = repository; }
    public FileOwnerType type() { return FileOwnerType.DOCUMENT; }
    public FileOwnerContext resolve(UUID tenantId, UUID ownerId) {
        var value = repository.findByIdAndTenantIdAndDeletedFalse(ownerId, tenantId)
                .orElseThrow(() -> new NotFoundException("Documento não encontrado."));
        return new FileOwnerContext(ownerId, value.getTitle(),
                value.getProject() == null ? null : value.getProject().getId(), null, null,
                value.getProposal() == null ? null : value.getProposal().getId(), value.getClient().getId());
    }
}
