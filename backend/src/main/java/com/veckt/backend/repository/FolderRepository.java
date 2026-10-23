package com.veckt.backend.repository;

import com.veckt.backend.entity.FileOwnerType;
import com.veckt.backend.entity.Folder;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, UUID> {
    Optional<Folder> findByIdAndTenantIdAndDeletedFalse(UUID id, UUID tenantId);
    List<Folder> findAllByTenantIdAndOwnerTypeAndOwnerIdAndDeletedFalseOrderByNameAsc(
            UUID tenantId, FileOwnerType ownerType, UUID ownerId);
    boolean existsByTenantIdAndOwnerTypeAndOwnerIdAndParentIdAndNameIgnoreCaseAndDeletedFalse(
            UUID tenantId, FileOwnerType ownerType, UUID ownerId, UUID parentId, String name);
    boolean existsByParentIdAndDeletedFalse(UUID parentId);
}
