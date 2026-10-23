package com.vectk.backend.mapper;

import com.vectk.backend.dto.ProposalDtos.ProposalRequest;
import com.vectk.backend.entity.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProposalMapper {
    @Mapping(target = "tenant", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "briefing", ignore = true)
    @Mapping(target = "originType", ignore = true)
    @Mapping(target = "number", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "subtotal", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "items", ignore = true)
    @Mapping(target = "paymentConditions", ignore = true)
    Proposal toEntity(ProposalRequest request);

    @Mapping(target = "tenant", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "briefing", ignore = true)
    @Mapping(target = "originType", ignore = true)
    @Mapping(target = "number", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "subtotal", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "items", ignore = true)
    @Mapping(target = "paymentConditions", ignore = true)
    void update(ProposalRequest request, @MappingTarget Proposal proposal);
}
