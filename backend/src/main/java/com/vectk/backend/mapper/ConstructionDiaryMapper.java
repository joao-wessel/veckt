package com.vectk.backend.mapper;

import com.vectk.backend.dto.ConstructionDiaryDtos.ParticipantResponse;
import com.vectk.backend.dto.ConstructionDiaryDtos.ObservationResponse;
import com.vectk.backend.entity.ConstructionDiaryObservation;
import com.vectk.backend.entity.ConstructionDiaryParticipant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConstructionDiaryMapper {
    @Mapping(target = "tenantUserId", source = "tenantUser.id")
    @Mapping(target = "name", expression = "java(entity.getTenantUser() != null ? entity.getTenantUser().getName() : entity.getName())")
    ParticipantResponse toResponse(ConstructionDiaryParticipant entity);
    ObservationResponse toResponse(ConstructionDiaryObservation entity);
}
