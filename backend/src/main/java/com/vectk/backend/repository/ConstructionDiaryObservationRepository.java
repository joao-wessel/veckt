package com.vectk.backend.repository;
import com.vectk.backend.entity.ConstructionDiaryObservation;
import java.util.List; import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface ConstructionDiaryObservationRepository extends JpaRepository<ConstructionDiaryObservation, UUID> { List<ConstructionDiaryObservation> findAllByDiaryEntryIdOrderByOrderAsc(UUID entryId); void deleteByDiaryEntryId(UUID entryId); }
