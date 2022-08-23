package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.TypeDto;
import com.digitalclick.finalproject.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TypeMapper extends EntityMapper<TypeDto, Type> {
}