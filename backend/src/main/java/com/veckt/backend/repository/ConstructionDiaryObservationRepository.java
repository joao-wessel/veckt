package com.veckt.backend.repository;
import com.veckt.backend.entity.ConstructionDiaryObservation;
import java.util.List; import java.util.UUID; import org.springframework.data.jpa.repository.JpaRepository;
public interface ConstructionDiaryObservationRepository extends JpaRepository<ConstructionDiaryObservation, UUID> { List<ConstructionDiaryObservation> findAllByDiaryEntryIdOrderByOrderAsc(UUID entryId); void deleteByDiaryEntryId(UUID entryId); }
