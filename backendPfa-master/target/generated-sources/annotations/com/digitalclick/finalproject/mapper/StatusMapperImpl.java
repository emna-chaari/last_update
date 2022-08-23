package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.StatusDto;
import com.digitalclick.finalproject.model.Status;
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
public class StatusMapperImpl implements StatusMapper {

    @Override
    public Status toEntity(StatusDto dto) {
        if ( dto == null ) {
            return null;
        }

        Status status = new Status();

        status.setDescription( dto.getDescription() );
        status.setUpdateDate( dto.getUpdateDate() );
        status.setAuthor( dto.getAuthor() );
        status.setTicketStatus( dto.getTicketStatus() );
        status.setId( dto.getId() );

        return status;
    }

    @Override
    public StatusDto toDto(Status entity) {
        if ( entity == null ) {
            return null;
        }

        StatusDto statusDto = new StatusDto();

        statusDto.setId( entity.getId() );
        statusDto.setDescription( entity.getDescription() );
        statusDto.setUpdateDate( entity.getUpdateDate() );
        statusDto.setAuthor( entity.getAuthor() );
        statusDto.setTicketStatus( entity.getTicketStatus() );

        return statusDto;
    }

    @Override
    public List<Status> toEntity(List<StatusDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Status> list = new ArrayList<Status>( dtoList.size() );
        for ( StatusDto statusDto : dtoList ) {
            list.add( toEntity( statusDto ) );
        }

        return list;
    }

    @Override
    public List<StatusDto> toDto(List<Status> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StatusDto> list = new ArrayList<StatusDto>( entityList.size() );
        for ( Status status : entityList ) {
            list.add( toDto( status ) );
        }

        return list;
    }

    @Override
    public Set<StatusDto> toDto(Set<Status> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<StatusDto> set = new LinkedHashSet<StatusDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Status status : entityList ) {
            set.add( toDto( status ) );
        }

        return set;
    }
}
