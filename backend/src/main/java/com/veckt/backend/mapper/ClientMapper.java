package com.veckt.backend.mapper;

import com.veckt.backend.dto.ClientDtos.ClientRequest;
import com.veckt.backend.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientRequest request);
    void update(ClientRequest request, @MappingTarget Client client);
}
