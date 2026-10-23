package com.veckt.backend.repository;

import com.veckt.backend.entity.AccessTokenType;
import com.veckt.backend.entity.PlatformUserToken;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformUserTokenRepository extends JpaRepository<PlatformUserToken, UUID> {
    Optional<PlatformUserToken> findByTokenHashAndType(String tokenHash, AccessTokenType type);
    void deleteByPlatformUser_IdAndType(UUID platformUserId, AccessTokenType type);
}
