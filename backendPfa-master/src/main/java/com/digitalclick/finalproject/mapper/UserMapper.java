package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.UserDto;
import com.digitalclick.finalproject.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {




}