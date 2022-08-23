package com.digitalclick.finalproject.service;

import com.digitalclick.finalproject.dto.StatusDto;
import com.digitalclick.finalproject.mapper.StatusMapper;
import com.digitalclick.finalproject.model.Status;
import com.digitalclick.finalproject.repository.StatusRepository;
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
public class StatusService {
    private final StatusRepository repository;
    private final StatusMapper statusMapper;

    public StatusService(StatusRepository repository, StatusMapper statusMapper) {
        this.repository = repository;
        this.statusMapper = statusMapper;
    }

    public StatusDto save(StatusDto statusDto) {



        Status entity = statusMapper.toEntity(statusDto);
        entity.setId(statusDto.getId());
        entity.setTicketStatus(statusDto.getTicketStatus());
        entity.setDescription(statusDto.getDescription());
        entity.setAuthor(statusDto.getAuthor());





        return statusMapper.toDto(repository.save(entity));
    }








    public void deleteById(int id) {
        repository.deleteById(id);
    }





    public StatusDto findById(int id) {

       Status entity = repository.findById(id).orElse(null);
        StatusDto statusDto = statusMapper.toDto(entity);
        statusDto.setId(entity.getId());
        statusDto.setDescription(entity.getDescription());
        statusDto.setAuthor(entity.getAuthor());
        statusDto.setUpdateDate(entity.getUpdateDate());
        statusDto.setTicketStatus(entity.getTicketStatus());


        return statusDto;



    }
















    public Page<StatusDto> findByCondition(StatusDto statusDto, Pageable pageable) {
        Page<Status> entityPage = repository.findAll(pageable);
        List<Status> entities = entityPage.getContent();
        return new PageImpl<>(statusMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public StatusDto update(StatusDto statusDto, int id) {
        StatusDto data = findById(id);
        Status entity = statusMapper.toEntity(statusDto);
        return save(statusMapper.toDto(entity));
    }

    public List<Status> fetchStatutsList() {
        return (List<Status>)
                repository.findAll();
    }
}