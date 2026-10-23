package com.vectk.backend.mapper;

import com.vectk.backend.dto.TenantDtos.TenantRequest;
import com.vectk.backend.dto.TenantDtos.TenantResponse;
import com.vectk.backend.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TenantMapper {
    Tenant toEntity(TenantRequest request);
    TenantResponse toResponse(Tenant tenant);
    void update(TenantRequest request, @MappingTarget Tenant tenant);
}
