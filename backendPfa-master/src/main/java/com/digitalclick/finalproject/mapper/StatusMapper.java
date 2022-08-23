package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.StatusDto;
import com.digitalclick.finalproject.model.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper extends EntityMapper<StatusDto, Status> {
}