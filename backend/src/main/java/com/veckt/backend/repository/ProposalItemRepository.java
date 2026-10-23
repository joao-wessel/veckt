package com.veckt.backend.repository;

import com.veckt.backend.entity.ProposalItem;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalItemRepository extends JpaRepository<ProposalItem, UUID> {
    List<ProposalItem> findAllByProposalIdOrderByCreatedAtAsc(UUID proposalId);
}
