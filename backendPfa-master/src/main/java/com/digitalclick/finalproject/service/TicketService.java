package com.digitalclick.finalproject.service;

import com.digitalclick.finalproject.dto.TicketDto;
import com.digitalclick.finalproject.mapper.TicketMapper;
import com.digitalclick.finalproject.model.Status;
import com.digitalclick.finalproject.model.Ticket;
import com.digitalclick.finalproject.model.User;
import com.digitalclick.finalproject.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@Slf4j
@Service
@Transactional
public class TicketService {
    private final TicketRepository repository;
    @Autowired
    private final TicketMapper ticketMapper;
    private EntityManager entityManager;
    private final StatusService statusService;
    public TicketService(TicketRepository repository, TicketMapper ticketMapper, EntityManager entityManager, StatusService statusService) {
        this.repository = repository;
        this.ticketMapper = ticketMapper;
        this.entityManager = entityManager;

        this.statusService = statusService;
    }

    @Transactional
    public Ticket create(Ticket ticket) {
        entityManager.persist(ticket);
        return ticket;
    }





    public TicketDto save(TicketDto ticketDto) {
        Ticket entity = new Ticket();
        Status status =new Status();
        status.setDescription("");
       // status.setAuthor(ticketDto.getCreatedBy().getFirstName() +" "+ticketDto.getCreatedBy().getLastName() );
      //  status.setTicketStatus(ticketDto.getTicketStatus());




        entity.setId(ticketDto.getId());
        entity.setTitle(ticketDto.getTitle());
        entity.setDescription(ticketDto.getDescription());
        entity.setAssignedTo(ticketDto.getAssignedTo());
        entity.setCreatedBy(ticketDto.getCreatedBy());
        entity.setRequestedBy(ticketDto.getRequestedBy());
      //  entity.setTicketStatus(ticketDto.getTicketStatus());
        entity.setDateClosed(ticketDto.getDateClosed());
        entity.setDateOpened(ticketDto.getDateOpened());
        entity.setCategory(ticketDto.getCategory());
        entity.setUpdates(Collections.singletonList(status));
        entity.setType(ticketDto.getType());
        entity.setLastUpdated(ticketDto.getLastUpdated());
        entity.setPriority(ticketDto.getPriority());
        entity.setStatusOfTicket((ticketDto.getStatusOfTicket()));
        Ticket savedEntity =repository.saveAndFlush(entity);



       return null;

    }
    public List<Ticket> fetchTicketList()
    {
        return (List<Ticket>)
                repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public TicketDto findById(Integer id) {

        Ticket entity = repository.findById(id).orElse(null);

        TicketDto ticketDto = ticketMapper.toDto(entity);
        ticketDto.setTitle(entity.getTitle());
        ticketDto.setDescription(entity.getDescription());
        ticketDto.setAssignedTo(entity.getAssignedTo());
        ticketDto.setCreatedBy(entity.getCreatedBy());
        //ticketDto.setTicketStatus(entity.getTicketStatus());
        ticketDto.setDateClosed(entity.getDateClosed());
        ticketDto.setDateOpened(entity.getDateOpened());
        ticketDto.setCategory(entity.getCategory());
       // ticketDto.setId(entity.getId());
        ticketDto.setUpdates(entity.getUpdates());
        ticketDto.setLastUpdated(entity.getLastUpdated());
        ticketDto.setPriority(entity.getPriority());
        ticketDto.setType(entity.getType());
        ticketDto.setRequestedBy(entity.getRequestedBy());
        ticketDto.setStatusOfTicket(entity.getStatusOfTicket());
        return ticketDto;
    }

    public List<Ticket> fetchTicketListByAssignedTo(Integer assigned_to_id)
    {
        return (List<Ticket>)
                repository.findAllByAssignedTo(assigned_to_id);
    }

    public List<Ticket> fetchTicketListByCreatedBy(Integer created_by_id)
    {
        return (List<Ticket>)
                repository.findAllByCreatedBy(created_by_id);
    }
    public List<Ticket> fetchTicketListByRequestedBy(Integer requested_by_id)
    {
        return (List<Ticket>)
                repository.findAllByRequestedBy(requested_by_id);
    }

    @Transactional
    public TicketDto saveTicketByAssignedTo(TicketDto ticketDto, Integer assigned_to_id) {
        Ticket entity = ticketMapper.toEntity(ticketDto);

        create(entity);
        User user = new User(assigned_to_id);
        entity.setAssignedTo(user);
        return ticketMapper.toDto(entity);

    }

    @Transactional
    public TicketDto saveTicketByCreatedBy(TicketDto ticketDto, Integer created_by_id) {
        Ticket entity = ticketMapper.toEntity(ticketDto);

        create(entity);
        User user = new User(created_by_id);
        entity.setCreatedBy(user);
        return ticketMapper.toDto(entity);

    }

    @Transactional
    public TicketDto saveTicketByRequestedBy(TicketDto ticketDto, Integer requested_by_id) {
        Ticket entity = ticketMapper.toEntity(ticketDto);

        create(entity);
        User user = new User(requested_by_id);
        entity.setRequestedBy(user);
        return ticketMapper.toDto(entity);

    }









    public Page<TicketDto> findByCondition(TicketDto ticketDto, Pageable pageable) {
        Page<Ticket> entityPage = repository.findAll(pageable);
        List<Ticket> entities = entityPage.getContent();
        return new PageImpl<>(ticketMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public TicketDto update(TicketDto ticketDto, Integer id) {
        TicketDto data = findById(id);
        Ticket entity = ticketMapper.toEntity(ticketDto);
        return save(ticketMapper.toDto(entity));
    }
}