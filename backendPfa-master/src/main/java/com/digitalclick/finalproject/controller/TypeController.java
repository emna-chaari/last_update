package com.digitalclick.finalproject.controller;

import com.digitalclick.finalproject.dto.CategoryDto;
import com.digitalclick.finalproject.dto.TypeDto;
import com.digitalclick.finalproject.mapper.TypeMapper;
import com.digitalclick.finalproject.model.Type;
import com.digitalclick.finalproject.model.User;
import com.digitalclick.finalproject.service.TypeService;
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
@RequestMapping("/type")
@RestController
@Slf4j
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated TypeDto typeDto) {
        typeService.save(typeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> findById(@PathVariable("id") Integer id) {
        TypeDto type = typeService.findById(id);
        return ResponseEntity.ok(type);
    }
    @GetMapping("/types")
    public List<Type> fetchTypeList()
    {
        return typeService.fetchTypeList();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        TypeDto typeDto = Optional.ofNullable(typeService.findById(id)).orElse(null);
        if (typeDto == null) {
            return ResponseEntity.notFound().build();
        }
        typeService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/page-query")
    public ResponseEntity<Page<TypeDto>> pageQuery(TypeDto typeDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<TypeDto> typePage = typeService.findByCondition(typeDto, pageable);
        return ResponseEntity.ok(typePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated TypeDto typeDto, @PathVariable("id") Integer id) {
        typeService.update(typeDto, id);
        return ResponseEntity.ok().build();
    }
}