package com.digitalclick.finalproject.service;

import com.digitalclick.finalproject.dto.CategoryDto;
import com.digitalclick.finalproject.dto.TypeDto;
import com.digitalclick.finalproject.mapper.TypeMapper;
import com.digitalclick.finalproject.model.Category;
import com.digitalclick.finalproject.model.Type;
import com.digitalclick.finalproject.model.User;
import com.digitalclick.finalproject.repository.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class TypeService {
    private final TypeRepository repository;
    private final TypeMapper typeMapper;

    public TypeService(TypeRepository repository, TypeMapper typeMapper) {
        this.repository = repository;
        this.typeMapper = typeMapper;
    }

    public TypeDto save(TypeDto typeDto) {
        Type entity = typeMapper.toEntity(typeDto);
        return typeMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public TypeDto findById(Integer id) {
        Type entity = repository.findById(id).orElse(null);
        TypeDto typeDto = typeMapper.toDto(entity);
        typeDto.setId(entity.getId());
        typeDto.setName(entity.getName());
        return typeDto;
    }

    public Page<TypeDto> findByCondition(TypeDto typeDto, Pageable pageable) {
        Page<Type> entityPage = repository.findAll(pageable);
        List<Type> entities = entityPage.getContent();
        return new PageImpl<>(typeMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public TypeDto update(TypeDto typeDto, Integer id) {
        TypeDto data = findById(id);
        Type entity = typeMapper.toEntity(typeDto);
        return save(typeMapper.toDto(entity));
    }

    public List<Type> fetchTypeList()
    {
        return (List<Type>)
                repository.findAll();
    }




}