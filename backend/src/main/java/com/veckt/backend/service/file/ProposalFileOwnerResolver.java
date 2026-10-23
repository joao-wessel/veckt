package com.veckt.backend.service.file;

import com.veckt.backend.entity.FileOwnerType;
import com.veckt.backend.exception.NotFoundException;
import com.veckt.backend.repository.ProjectRepository;
import com.veckt.backend.repository.ProposalRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ProposalFileOwnerResolver implements FileOwnerResolver {
    private final ProposalRepository repository;
    private final ProjectRepository projectRepository;
    public ProposalFileOwnerResolver(ProposalRepository repository, ProjectRepository projectRepository) {
        this.repository = repository;
        this.projectRepository = projectRepository;
    }
    public FileOwnerType type() { return FileOwnerType.PROPOSAL; }
    public FileOwnerContext resolve(UUID tenantId, UUID ownerId) {
        var value = repository.findByIdAndTenantIdAndDeletedFalse(ownerId, tenantId)
                .orElseThrow(() -> new NotFoundException("Proposta não encontrada."));
        var projectId = projectRepository.findByProposalIdAndDeletedFalse(value.getId()).map(item -> item.getId()).orElse(null);
        return new FileOwnerContext(ownerId, value.getNumber(), projectId, null, null, value.getId(), value.getClient().getId());
    }
}
