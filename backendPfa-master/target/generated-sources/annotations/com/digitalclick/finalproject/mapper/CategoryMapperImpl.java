package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.CategoryDto;
import com.digitalclick.finalproject.model.Category;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( dto.getId() );
        category.setName( dto.getName() );

        return category;
    }

    @Override
    public CategoryDto toDto(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( entity.getId() );
        categoryDto.setName( entity.getName() );

        return categoryDto;
    }

    @Override
    public List<Category> toEntity(List<CategoryDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( dtoList.size() );
        for ( CategoryDto categoryDto : dtoList ) {
            list.add( toEntity( categoryDto ) );
        }

        return list;
    }

    @Override
    public List<CategoryDto> toDto(List<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( entityList.size() );
        for ( Category category : entityList ) {
            list.add( toDto( category ) );
        }

        return list;
    }

    @Override
    public Set<CategoryDto> toDto(Set<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<CategoryDto> set = new LinkedHashSet<CategoryDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Category category : entityList ) {
            set.add( toDto( category ) );
        }

        return set;
    }
}
