package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.TicketDto;
import com.digitalclick.finalproject.model.Status;
import com.digitalclick.finalproject.model.Ticket;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T11:06:21+0100",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public Ticket toEntity(TicketDto dto) {
        if ( dto == null ) {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setId( dto.getId() );
        ticket.setTitle( dto.getTitle() );
        ticket.setDescription( dto.getDescription() );
        ticket.setDateOpened( dto.getDateOpened() );
        ticket.setDateClosed( dto.getDateClosed() );
        ticket.setLastUpdated( dto.getLastUpdated() );
        ticket.setCreatedBy( dto.getCreatedBy() );
        ticket.setAssignedTo( dto.getAssignedTo() );
        ticket.setTicketStatus( dto.getTicketStatus() );
        ticket.setStatusOfTicket(dto.getStatusOfTicket());
        ticket.setRequestedBy( dto.getRequestedBy() );
        ticket.setCategory( dto.getCategory() );
        List<Status> list = dto.getUpdates();
        if ( list != null ) {
            ticket.setUpdates( new ArrayList<Status>( list ) );
        }
        ticket.setPriority( dto.getPriority() );
        ticket.setType( dto.getType() );

        return ticket;
    }

    @Override
    public TicketDto toDto(Ticket entity) {
        if ( entity == null ) {
            return null;
        }

        TicketDto ticketDto = new TicketDto();

        ticketDto.setRequestedBy( entity.getRequestedBy() );
        ticketDto.setId( entity.getId() );
        ticketDto.setTitle( entity.getTitle() );
        ticketDto.setDescription( entity.getDescription() );
        ticketDto.setDateOpened( entity.getDateOpened() );
        ticketDto.setDateClosed( entity.getDateClosed() );
        ticketDto.setLastUpdated( entity.getLastUpdated() );
        List<Status> list = entity.getUpdates();
        if ( list != null ) {
            ticketDto.setUpdates( new ArrayList<Status>( list ) );
        }
        ticketDto.setCreatedBy( entity.getCreatedBy() );
        ticketDto.setAssignedTo( entity.getAssignedTo() );
          ticketDto.setTicketStatus( entity.getTicketStatus() );
        ticketDto.setStatusOfTicket(entity.getStatusOfTicket());
        ticketDto.setCategory( entity.getCategory() );
        ticketDto.setPriority( entity.getPriority() );
        ticketDto.setType( entity.getType() );

        return ticketDto;
    }

    @Override
    public List<Ticket> toEntity(List<TicketDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Ticket> list = new ArrayList<Ticket>( dtoList.size() );
        for ( TicketDto ticketDto : dtoList ) {
            list.add( toEntity( ticketDto ) );
        }

        return list;
    }

    @Override
    public List<TicketDto> toDto(List<Ticket> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TicketDto> list = new ArrayList<TicketDto>( entityList.size() );
        for ( Ticket ticket : entityList ) {
            list.add( toDto( ticket ) );
        }

        return list;
    }

    @Override
    public Set<TicketDto> toDto(Set<Ticket> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<TicketDto> set = new LinkedHashSet<TicketDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Ticket ticket : entityList ) {
            set.add( toDto( ticket ) );
        }

        return set;
    }
}
