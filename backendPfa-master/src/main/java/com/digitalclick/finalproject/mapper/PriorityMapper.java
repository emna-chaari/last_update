package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.PriorityDto;
import com.digitalclick.finalproject.model.Priority;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriorityMapper extends EntityMapper<PriorityDto, Priority> {
}