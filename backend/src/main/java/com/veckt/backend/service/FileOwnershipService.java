package com.veckt.backend.service;

import com.veckt.backend.entity.FileOwnerType;
import com.veckt.backend.exception.BusinessException;
import com.veckt.backend.service.file.FileOwnerContext;
import com.veckt.backend.service.file.FileOwnerResolver;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class FileOwnershipService {
    private final Map<FileOwnerType, FileOwnerResolver> resolvers = new EnumMap<>(FileOwnerType.class);

    public FileOwnershipService(List<FileOwnerResolver> resolvers) {
        resolvers.forEach(resolver -> this.resolvers.put(resolver.type(), resolver));
    }

    public FileOwnerContext validate(UUID tenantId, FileOwnerType ownerType, UUID ownerId) {
        var resolver = resolvers.get(ownerType);
        if (resolver == null) throw new BusinessException("Tipo de proprietário de arquivo não suportado.");
        return resolver.resolve(tenantId, ownerId);
    }
}
