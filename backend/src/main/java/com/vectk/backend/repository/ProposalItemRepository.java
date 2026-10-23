package com.vectk.backend.repository;

import com.vectk.backend.entity.ProposalItem;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalItemRepository extends JpaRepository<ProposalItem, UUID> {
    List<ProposalItem> findAllByProposalIdOrderByCreatedAtAsc(UUID proposalId);
}
