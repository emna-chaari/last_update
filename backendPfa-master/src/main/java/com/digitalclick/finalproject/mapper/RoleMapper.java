package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.RoleDto;
import com.digitalclick.finalproject.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDto, Role> {
}