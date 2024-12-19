package com.ys.skywingracing.pigeon.application.mapper;


import com.ys.skywingracing.pigeon.application.dto.request.PigeonRequestDTO;
import com.ys.skywingracing.pigeon.application.dto.response.PigeonResponseDTO;
import com.ys.skywingracing.pigeon.domain.model.Pigeon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PigeonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    Pigeon toEntity (PigeonRequestDTO dto );

    PigeonResponseDTO toDto (Pigeon pigeon );

}
