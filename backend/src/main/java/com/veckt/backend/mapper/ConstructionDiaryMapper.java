package com.veckt.backend.mapper;

import com.veckt.backend.dto.ConstructionDiaryDtos.ParticipantResponse;
import com.veckt.backend.dto.ConstructionDiaryDtos.ObservationResponse;
import com.veckt.backend.entity.ConstructionDiaryObservation;
import com.veckt.backend.entity.ConstructionDiaryParticipant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConstructionDiaryMapper {
    @Mapping(target = "tenantUserId", source = "tenantUser.id")
    @Mapping(target = "name", expression = "java(entity.getTenantUser() != null ? entity.getTenantUser().getName() : entity.getName())")
    ParticipantResponse toResponse(ConstructionDiaryParticipant entity);
    ObservationResponse toResponse(ConstructionDiaryObservation entity);
}
