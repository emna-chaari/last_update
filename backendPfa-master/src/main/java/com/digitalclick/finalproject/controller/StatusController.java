package com.digitalclick.finalproject.controller;

import com.digitalclick.finalproject.dto.StatusDto;
import com.digitalclick.finalproject.model.Status;
import com.digitalclick.finalproject.service.StatusService;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/status")
@RestController
@Slf4j
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated StatusDto statusDto) {
        statusService.save(statusDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/statut")
    public List<Status> fetchStatutsList()
    {
        return statusService.fetchStatutsList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> findById(@PathVariable("id") int id) {
        StatusDto status = statusService.findById(id);
        return ResponseEntity.ok(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        StatusDto statusDto =Optional.ofNullable(statusService.findById(id)).orElse( null);
        if (statusDto==null){ return ResponseEntity.notFound().build();}
       statusService.deleteById(id);
        return ResponseEntity.ok().build();
    }




    @GetMapping("/page-query")
    public ResponseEntity<Page<StatusDto>> pageQuery(StatusDto statusDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<StatusDto> statusPage = statusService.findByCondition(statusDto, pageable);
        return ResponseEntity.ok(statusPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated StatusDto statusDto, @PathVariable("id") int id) {
        statusService.update(statusDto, id);
        return ResponseEntity.ok().build();
    }
}