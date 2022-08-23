package com.digitalclick.finalproject.mapper;

import com.digitalclick.finalproject.dto.CategoryDto;
import com.digitalclick.finalproject.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category> {
}