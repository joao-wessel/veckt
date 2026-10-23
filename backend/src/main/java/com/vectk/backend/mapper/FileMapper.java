package com.vectk.backend.mapper;

import com.vectk.backend.dto.FileDtos.FileResponse;
import com.vectk.backend.dto.FileDtos.FileVersionResponse;
import com.vectk.backend.dto.FileDtos.FolderResponse;
import com.vectk.backend.entity.FileResource;
import com.vectk.backend.entity.FileVersion;
import com.vectk.backend.entity.Folder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FileMapper {
    @Mapping(target = "parentId", source = "parent.id")
    FolderResponse toResponse(Folder folder);

    @Mapping(target = "folderId", source = "folder.id")
    @Mapping(target = "folderName", source = "folder.name")
    @Mapping(target = "ownerLabel", ignore = true)
    @Mapping(target = "uploadedById", source = "uploadedBy.id")
    @Mapping(target = "uploadedByName", source = "uploadedBy.name")
    @Mapping(target = "tags", expression = "java(file.getTags().stream().map(com.vectk.backend.entity.FileTag::getName).sorted().toList())")
    @Mapping(target = "previewAvailable", ignore = true)
    FileResponse toResponse(FileResource file);

    @Mapping(target = "authorId", source = "author.id")
    @Mapping(target = "authorName", source = "author.name")
    FileVersionResponse toResponse(FileVersion version);
}
