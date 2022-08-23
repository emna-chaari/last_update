package com.digitalclick.finalproject.service;

import com.digitalclick.finalproject.dto.CategoryDto;
import com.digitalclick.finalproject.mapper.CategoryMapper;
import com.digitalclick.finalproject.model.Category;
import com.digitalclick.finalproject.model.User;
import com.digitalclick.finalproject.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository repository, CategoryMapper categoryMapper) {
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }


    public CategoryDto save(CategoryDto categoryDto) {
        Category entity = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }




    public CategoryDto findById(Integer id) {

        Category entity = repository.findById(id).orElse(null);
        CategoryDto categoryDto = categoryMapper.toDto(entity);
        categoryDto.setId(entity.getId());
        categoryDto.setName(entity.getName());
        return categoryDto;


    }



    public List<Category> fetchCategoryList()
    {
        return (List<Category>)
                repository.findAll();
    }




    public Page<CategoryDto> findByCondition(CategoryDto categoryDto, Pageable pageable) {
        Page<Category> entityPage = repository.findAll(pageable);
        List<Category> entities = entityPage.getContent();
        return new PageImpl<>(categoryMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public CategoryDto update(CategoryDto categoryDto, Integer id) {
        CategoryDto data = findById(id);
        Category entity = categoryMapper.toEntity(categoryDto);
        return save(categoryMapper.toDto(entity));
    }
}