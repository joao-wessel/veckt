package com.veckt.backend.service.file;

import com.veckt.backend.entity.FileOwnerType;
import java.util.UUID;

public interface FileOwnerResolver {
    FileOwnerType type();
    FileOwnerContext resolve(UUID tenantId, UUID ownerId);
}
