package com.ys.skywingracing.pigeon.application.mapper;


import com.ys.skywingracing.pigeon.application.dto.request.PigeonRequestDTO;
import com.ys.skywingracing.pigeon.application.dto.response.PigeonResponseDTO;
import com.ys.skywingracing.pigeon.domain.model.Pigeon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring")
public interface PigeonMapper {

    Pigeon toEntity (PigeonRequestDTO dto );

    PigeonResponseDTO toDto (Pigeon pigeon );

}
