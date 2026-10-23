package com.vectk.backend.repository;

import com.vectk.backend.entity.FileTag;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileTagRepository extends JpaRepository<FileTag, UUID> {
    Optional<FileTag> findByTenantIdAndNameIgnoreCase(UUID tenantId, String name);
    List<FileTag> findAllByTenantIdOrderByNameAsc(UUID tenantId);
}
