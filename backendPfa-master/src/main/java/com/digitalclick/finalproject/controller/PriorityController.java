package com.digitalclick.finalproject.controller;

import com.digitalclick.finalproject.dto.CategoryDto;
import com.digitalclick.finalproject.dto.PriorityDto;
import com.digitalclick.finalproject.mapper.PriorityMapper;
import com.digitalclick.finalproject.model.Priority;
import com.digitalclick.finalproject.model.Type;
import com.digitalclick.finalproject.service.PriorityService;
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
@RequestMapping("/priority")
@RestController
@Slf4j
public class PriorityController {
    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated PriorityDto priorityDto) {
        priorityService.save(priorityDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriorityDto> findById(@PathVariable("id") Integer id) {
        PriorityDto priority = priorityService.findById(id);
        return ResponseEntity.ok(priority);
    }


    @GetMapping("/priorities")
    public List<Priority> fetchPriorityList()
    {
        return priorityService.fetchPriorityList();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        PriorityDto priorityDto = Optional.ofNullable(priorityService.findById(id)).orElse(null);
        if (priorityDto == null) {
            return ResponseEntity.notFound().build();
        }
        priorityService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<PriorityDto>> pageQuery(PriorityDto priorityDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PriorityDto> priorityPage = priorityService.findByCondition(priorityDto, pageable);
        return ResponseEntity.ok(priorityPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated PriorityDto priorityDto, @PathVariable("id") Integer id) {
        priorityService.update(priorityDto, id);
        return ResponseEntity.ok().build();
    }
}