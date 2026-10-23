package com.vectk.backend.repository;

import com.vectk.backend.entity.ProjectService;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectServiceRepository extends JpaRepository<ProjectService, UUID> {
    List<ProjectService> findAllByProjectIdOrderByCreatedAtAsc(UUID projectId);
}
