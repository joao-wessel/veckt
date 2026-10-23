package com.veckt.backend.repository;

import com.veckt.backend.entity.PlatformUser;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformUserRepository extends JpaRepository<PlatformUser, UUID> {
    Optional<PlatformUser> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
}
