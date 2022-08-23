package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.PriorityDto;
import com.digitalclick.finalproject.model.Priority;
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
public class PriorityMapperImpl implements PriorityMapper {

    @Override
    public Priority toEntity(PriorityDto dto) {
        if ( dto == null ) {
            return null;
        }

        Priority priority = new Priority();

        priority.setId( dto.getId() );
        priority.setName( dto.getName() );

        return priority;
    }

    @Override
    public PriorityDto toDto(Priority entity) {
        if ( entity == null ) {
            return null;
        }

        PriorityDto priorityDto = new PriorityDto();

        priorityDto.setId( entity.getId() );
        priorityDto.setName( entity.getName() );

        return priorityDto;
    }

    @Override
    public List<Priority> toEntity(List<PriorityDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Priority> list = new ArrayList<Priority>( dtoList.size() );
        for ( PriorityDto priorityDto : dtoList ) {
            list.add( toEntity( priorityDto ) );
        }

        return list;
    }

    @Override
    public List<PriorityDto> toDto(List<Priority> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PriorityDto> list = new ArrayList<PriorityDto>( entityList.size() );
        for ( Priority priority : entityList ) {
            list.add( toDto( priority ) );
        }

        return list;
    }

    @Override
    public Set<PriorityDto> toDto(Set<Priority> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<PriorityDto> set = new LinkedHashSet<PriorityDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Priority priority : entityList ) {
            set.add( toDto( priority ) );
        }

        return set;
    }
}
