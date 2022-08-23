package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.TypeDto;
import com.digitalclick.finalproject.model.Type;
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
public class TypeMapperImpl implements TypeMapper {

    @Override
    public Type toEntity(TypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Type type = new Type();

        type.setId( dto.getId() );
        type.setName( dto.getName() );

        return type;
    }

    @Override
    public TypeDto toDto(Type entity) {
        if ( entity == null ) {
            return null;
        }

        TypeDto typeDto = new TypeDto();

        typeDto.setId( entity.getId() );
        typeDto.setName( entity.getName() );

        return typeDto;
    }

    @Override
    public List<Type> toEntity(List<TypeDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Type> list = new ArrayList<Type>( dtoList.size() );
        for ( TypeDto typeDto : dtoList ) {
            list.add( toEntity( typeDto ) );
        }

        return list;
    }

    @Override
    public List<TypeDto> toDto(List<Type> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TypeDto> list = new ArrayList<TypeDto>( entityList.size() );
        for ( Type type : entityList ) {
            list.add( toDto( type ) );
        }

        return list;
    }

    @Override
    public Set<TypeDto> toDto(Set<Type> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<TypeDto> set = new LinkedHashSet<TypeDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Type type : entityList ) {
            set.add( toDto( type ) );
        }

        return set;
    }
}
