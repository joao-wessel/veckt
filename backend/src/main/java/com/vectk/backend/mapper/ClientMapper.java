package com.vectk.backend.mapper;

import com.vectk.backend.dto.ClientDtos.ClientRequest;
import com.vectk.backend.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientRequest request);
    void update(ClientRequest request, @MappingTarget Client client);
}
