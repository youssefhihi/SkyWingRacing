package com.ys.skywingracing.user.application.mapper;

import com.ys.skywingracing.user.application.dto.response.UserResponseDto;
import com.ys.skywingracing.user.domain.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "name", source = "entity.name")
    UserResponseDto toResponseDto(User entity);


}