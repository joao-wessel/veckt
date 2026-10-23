package com.veckt.backend.service.file;

import com.veckt.backend.entity.FileOwnerType;
import com.veckt.backend.exception.NotFoundException;
import com.veckt.backend.repository.BriefingRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class BriefingFileOwnerResolver implements FileOwnerResolver {
    private final BriefingRepository repository;
    public BriefingFileOwnerResolver(BriefingRepository repository) { this.repository = repository; }
    public FileOwnerType type() { return FileOwnerType.BRIEFING; }
    public FileOwnerContext resolve(UUID tenantId, UUID ownerId) {
        var value = repository.findByIdAndTenantIdAndDeletedFalse(ownerId, tenantId)
                .orElseThrow(() -> new NotFoundException("Briefing não encontrado."));
        return new FileOwnerContext(ownerId, value.getTitle(), null, null, null, null, value.getClient().getId());
    }
}
