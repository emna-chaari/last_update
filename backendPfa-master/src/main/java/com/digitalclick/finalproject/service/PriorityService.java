package com.digitalclick.finalproject.service;

import com.digitalclick.finalproject.dto.CategoryDto;
import com.digitalclick.finalproject.dto.PriorityDto;
import com.digitalclick.finalproject.mapper.PriorityMapper;
import com.digitalclick.finalproject.model.Category;
import com.digitalclick.finalproject.model.Priority;
import com.digitalclick.finalproject.repository.PriorityRepository;
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
public class PriorityService {
    private final PriorityRepository repository;
    private final PriorityMapper priorityMapper;

    public PriorityService(PriorityRepository repository, PriorityMapper priorityMapper) {
        this.repository = repository;
        this.priorityMapper = priorityMapper;
    }

    public PriorityDto save(PriorityDto priorityDto) {
        Priority entity = priorityMapper.toEntity(priorityDto);
        return priorityMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public PriorityDto findById(Integer id) {

        Priority entity = repository.findById(id).orElse(null);
        PriorityDto priorityDto = priorityMapper.toDto(entity);
        priorityDto.setId(entity.getId());
        priorityDto.setName(entity.getName());
        return priorityDto;


    }



    public List<Priority> fetchPriorityList()
    {
        return (List<Priority>)
                repository.findAll();
    }

    public Page<PriorityDto> findByCondition(PriorityDto priorityDto, Pageable pageable) {
        Page<Priority> entityPage = repository.findAll(pageable);
        List<Priority> entities = entityPage.getContent();
        return new PageImpl<>(priorityMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public PriorityDto update(PriorityDto priorityDto, Integer id) {
        PriorityDto data = findById(id);
        Priority entity = priorityMapper.toEntity(priorityDto);
        return save(priorityMapper.toDto(entity));
    }
}