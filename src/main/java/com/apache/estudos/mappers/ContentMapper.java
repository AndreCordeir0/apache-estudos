package com.apache.estudos.mappers;


import com.apache.estudos.DTO.ContentDTO;
import com.apache.estudos.entity.Content;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContentMapper {

    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    List<ContentDTO> listContentToDTO(List<Content> contents);
}
