package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.TicketDto;
import com.digitalclick.finalproject.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper extends EntityMapper<TicketDto, Ticket> {
}