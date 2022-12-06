package com.apache.estudos.mappers;

import com.apache.estudos.DTO.JujutsuDTO;
import com.apache.estudos.entity.Jujutsu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Base64;
import java.util.Objects;

@Mapper
public interface JujutsuMapper {

    JujutsuMapper INSTANCE = Mappers.getMapper(JujutsuMapper.class);


    @Mapping(source = "jujutsu.cardUrl",target = "cardUrl",qualifiedByName = "byteToString")
    JujutsuDTO  jujutsuToDTO(Jujutsu jujutsu);

    @Named("byteToString")
    default String byteToString(byte[] cardUrl){
        if(Objects.isNull(cardUrl)){
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(cardUrl);
        return base64;
    }
}
