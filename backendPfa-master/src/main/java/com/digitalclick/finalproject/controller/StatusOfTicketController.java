package com.digitalclick.finalproject.controller;

import com.digitalclick.finalproject.dto.StatusOfTicketDto;
import com.digitalclick.finalproject.dto.TypeDto;
import com.digitalclick.finalproject.mapper.StatusOfTicketMapper;
import com.digitalclick.finalproject.model.StatusOfTicket;
import com.digitalclick.finalproject.model.Type;
import com.digitalclick.finalproject.service.StatusOfTicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/status-of-ticket")
@RestController
@Slf4j
public class StatusOfTicketController {
    private final StatusOfTicketService statusOfTicketService;

    public StatusOfTicketController(StatusOfTicketService statusOfTicketService) {
        this.statusOfTicketService = statusOfTicketService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated StatusOfTicketDto statusOfTicketDto) {
        statusOfTicketService.save(statusOfTicketDto);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/status-of-tickets")
    public List<StatusOfTicket> fetchStatusOfTicketList()
    {
        return statusOfTicketService.fetchStatusOfTicketList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<StatusOfTicketDto> findById(@PathVariable("id") Integer id) {
        StatusOfTicketDto statusOfTicket = statusOfTicketService.findById(id);
        return ResponseEntity.ok(statusOfTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        StatusOfTicketDto statusOfTicketDto = Optional.ofNullable(statusOfTicketService.findById(id)).orElse(null);
        if (statusOfTicketDto == null) {
            return ResponseEntity.notFound().build();
        }
        statusOfTicketService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<StatusOfTicketDto>> pageQuery(StatusOfTicketDto statusOfTicketDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<StatusOfTicketDto> statusOfTicketPage = statusOfTicketService.findByCondition(statusOfTicketDto, pageable);
        return ResponseEntity.ok(statusOfTicketPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated StatusOfTicketDto statusOfTicketDto, @PathVariable("id") Integer id) {
        statusOfTicketService.update(statusOfTicketDto, id);
        return ResponseEntity.ok().build();
    }
}