package com.veckt.backend.mapper;

import com.veckt.backend.dto.TenantDtos.TenantRequest;
import com.veckt.backend.dto.TenantDtos.TenantResponse;
import com.veckt.backend.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TenantMapper {
    Tenant toEntity(TenantRequest request);
    TenantResponse toResponse(Tenant tenant);
    void update(TenantRequest request, @MappingTarget Tenant tenant);
}
