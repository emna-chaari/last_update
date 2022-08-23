package com.digitalclick.finalproject.service;

import com.digitalclick.finalproject.dto.StatusOfTicketDto;
import com.digitalclick.finalproject.dto.TypeDto;
import com.digitalclick.finalproject.mapper.StatusOfTicketMapper;
import com.digitalclick.finalproject.model.StatusOfTicket;
import com.digitalclick.finalproject.model.Type;
import com.digitalclick.finalproject.repository.StatusOfTicketRepository;
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
public class StatusOfTicketService {
    private final StatusOfTicketRepository repository;
    private final StatusOfTicketMapper statusOfTicketMapper;

    public StatusOfTicketService(StatusOfTicketRepository repository, StatusOfTicketMapper statusOfTicketMapper) {
        this.repository = repository;
        this.statusOfTicketMapper = statusOfTicketMapper;
    }

    public StatusOfTicketDto save(StatusOfTicketDto statusOfTicketDto) {
        StatusOfTicket entity = statusOfTicketMapper.toEntity(statusOfTicketDto);
        return statusOfTicketMapper.toDto(repository.save(entity));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public StatusOfTicketDto findById(Integer id) {
        StatusOfTicket entity = repository.findById(id).orElse(null);
        StatusOfTicketDto statusOfTicketDto = statusOfTicketMapper.toDto(entity);
        statusOfTicketDto.setId(entity.getId());
        statusOfTicketDto.setName(entity.getName());
        return statusOfTicketDto;
    }

    public Page<StatusOfTicketDto> findByCondition(StatusOfTicketDto statusOfTicketDto, Pageable pageable) {
        Page<StatusOfTicket> entityPage = repository.findAll(pageable);
        List<StatusOfTicket> entities = entityPage.getContent();
        return new PageImpl<>(statusOfTicketMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public StatusOfTicketDto update(StatusOfTicketDto statusOfTicketDto, Integer id) {
        StatusOfTicketDto data = findById(id);
        StatusOfTicket entity = statusOfTicketMapper.toEntity(statusOfTicketDto);
        return save(statusOfTicketMapper.toDto(entity));
    }


    public List<StatusOfTicket> fetchStatusOfTicketList()
    {
        return (List<StatusOfTicket>)
                repository.findAll();
    }


}