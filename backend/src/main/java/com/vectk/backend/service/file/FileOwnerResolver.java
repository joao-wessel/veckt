package com.vectk.backend.service.file;

import com.vectk.backend.entity.FileOwnerType;
import java.util.UUID;

public interface FileOwnerResolver {
    FileOwnerType type();
    FileOwnerContext resolve(UUID tenantId, UUID ownerId);
}
