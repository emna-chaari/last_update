package com.digitalclick.finalproject.controller;

import com.digitalclick.finalproject.dto.TicketDto;
import com.digitalclick.finalproject.dto.UserDto;
import com.digitalclick.finalproject.model.Ticket;
import com.digitalclick.finalproject.model.User;
import com.digitalclick.finalproject.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/ticket")
@RestController
@Slf4j
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping("/tickets")
    public List<Ticket> fetchTicketList()
    {
        return ticketService.fetchTicketList();
    }



    @GetMapping("/tickets/assignedto/{assigned_to_id}")
    public List<Ticket> fetchTicketListByAssignedTo(@PathVariable("assigned_to_id") Integer assigned_to_id)
    {
        return ticketService.fetchTicketListByAssignedTo(assigned_to_id);
    }


    @PostMapping({"/tickets/assigned/{assigned_to_id}/add-new"})
    public ResponseEntity<Void> saveTicketByAssignedTo(@RequestBody @Validated TicketDto ticketDto, @PathVariable("assigned_to_id") Integer assigned_to_id) {
        ticketService.saveTicketByAssignedTo(ticketDto, assigned_to_id);
        return ResponseEntity.ok().build();
    }

    @PostMapping({"tickets/created/{created_by_id}/add-new"})
    public ResponseEntity<Void> saveTicketByCreatedBy(@RequestBody @Validated TicketDto ticketDto, @PathVariable("created_by_id") Integer created_by_id) {
        ticketService.saveTicketByCreatedBy(ticketDto, created_by_id);
        return ResponseEntity.ok().build();
    }

    @PostMapping({"tickets/requested/{requested_by_id}/add-new"})
    public ResponseEntity<Void> saveTicketByRequestedBy(@RequestBody @Validated TicketDto ticketDto, @PathVariable("requested_by_id") Integer requested_by_id) {
        ticketService.saveTicketByRequestedBy(ticketDto, requested_by_id);
        return ResponseEntity.ok().build();
    }



    @GetMapping("/tickets/createdby/{created_by_id}")
    public List<Ticket> fetchTicketListByCreatedBy(@PathVariable("created_by_id") Integer created_by_id)
    {
        return ticketService.fetchTicketListByCreatedBy(created_by_id);
    }

    @GetMapping("/tickets/requestedby/{requested_by_id}")
    public List<Ticket> fetchTicketListByRequestedBy(@PathVariable("requested_by_id") Integer requested_by_id)
    {
        return ticketService.fetchTicketListByRequestedBy(requested_by_id);
    }






    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated TicketDto ticketDto) {
        ticketService.save(ticketDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> findById(@PathVariable("id") Integer id) {
        TicketDto ticket = ticketService.findById(id);
        return ResponseEntity.ok(ticket);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        TicketDto ticketDto =Optional.ofNullable(ticketService.findById(id)).orElse( null);
        if (ticketDto==null){ return ResponseEntity.notFound().build();}
        ticketService.deleteById(id);
        return ResponseEntity.ok().build();
    }















    @GetMapping("/page-query")
    public ResponseEntity<Page<TicketDto>> pageQuery(TicketDto ticketDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<TicketDto> ticketPage = ticketService.findByCondition(ticketDto, pageable);
        return ResponseEntity.ok(ticketPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated TicketDto ticketDto, @PathVariable("id") Integer id) {
        ticketService.update(ticketDto, id);
        return ResponseEntity.ok().build();
    }
}