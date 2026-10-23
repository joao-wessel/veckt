package com.vectk.backend.mapper;

import com.vectk.backend.dto.ServiceCatalogDtos.ServiceCategoryRequest;
import com.vectk.backend.entity.ServiceCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ServiceCategoryMapper {
    ServiceCategory toEntity(ServiceCategoryRequest request);
    void update(ServiceCategoryRequest request, @MappingTarget ServiceCategory category);
}
