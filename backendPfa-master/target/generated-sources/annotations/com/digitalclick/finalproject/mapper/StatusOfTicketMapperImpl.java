package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.StatusOfTicketDto;
import com.digitalclick.finalproject.model.StatusOfTicket;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-23T12:48:06+0100",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class StatusOfTicketMapperImpl implements StatusOfTicketMapper {

    @Override
    public StatusOfTicket toEntity(StatusOfTicketDto dto) {
        if ( dto == null ) {
            return null;
        }

        StatusOfTicket statusOfTicket = new StatusOfTicket();

        statusOfTicket.setId( dto.getId() );
        statusOfTicket.setName( dto.getName() );

        return statusOfTicket;
    }

    @Override
    public StatusOfTicketDto toDto(StatusOfTicket entity) {
        if ( entity == null ) {
            return null;
        }

        StatusOfTicketDto statusOfTicketDto = new StatusOfTicketDto();

        statusOfTicketDto.setId( entity.getId() );
        statusOfTicketDto.setName( entity.getName() );

        return statusOfTicketDto;
    }

    @Override
    public List<StatusOfTicket> toEntity(List<StatusOfTicketDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<StatusOfTicket> list = new ArrayList<StatusOfTicket>( dtoList.size() );
        for ( StatusOfTicketDto statusOfTicketDto : dtoList ) {
            list.add( toEntity( statusOfTicketDto ) );
        }

        return list;
    }

    @Override
    public List<StatusOfTicketDto> toDto(List<StatusOfTicket> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StatusOfTicketDto> list = new ArrayList<StatusOfTicketDto>( entityList.size() );
        for ( StatusOfTicket statusOfTicket : entityList ) {
            list.add( toDto( statusOfTicket ) );
        }

        return list;
    }

    @Override
    public Set<StatusOfTicketDto> toDto(Set<StatusOfTicket> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<StatusOfTicketDto> set = new LinkedHashSet<StatusOfTicketDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( StatusOfTicket statusOfTicket : entityList ) {
            set.add( toDto( statusOfTicket ) );
        }

        return set;
    }
}
