package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.StatusOfTicketDto;
import com.digitalclick.finalproject.model.StatusOfTicket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatusOfTicketMapper extends EntityMapper<StatusOfTicketDto, StatusOfTicket> {
}