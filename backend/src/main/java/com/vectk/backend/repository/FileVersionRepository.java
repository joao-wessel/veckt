package com.vectk.backend.repository;

import com.vectk.backend.entity.FileVersion;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileVersionRepository extends JpaRepository<FileVersion, UUID> {
    List<FileVersion> findAllByFileIdOrderByVersionNumberDesc(UUID fileId);
    Optional<FileVersion> findByIdAndFileTenantId(UUID id, UUID tenantId);
}
