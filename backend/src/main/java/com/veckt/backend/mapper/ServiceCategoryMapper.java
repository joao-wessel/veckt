package com.veckt.backend.mapper;

import com.veckt.backend.dto.ServiceCatalogDtos.ServiceCategoryRequest;
import com.veckt.backend.entity.ServiceCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServiceCategoryMapper {
    ServiceCategory toEntity(ServiceCategoryRequest request);
    void update(ServiceCategoryRequest request, @MappingTarget ServiceCategory category);
}
