package com.digitalclick.finalproject.controller;

import com.digitalclick.finalproject.dto.RoleDto;
import com.digitalclick.finalproject.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
@RestController
@Slf4j
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated RoleDto roleDto) {
        roleService.save(roleDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable("id") Integer id) {
        RoleDto role = roleService.findById(id);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        RoleDto roleDto =Optional.ofNullable(roleService.findById(id)).orElse( null);
        if (roleDto==null){ return ResponseEntity.notFound().build();}
       roleService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<RoleDto>> pageQuery(RoleDto roleDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<RoleDto> rolePage = roleService.findByCondition(roleDto, pageable);
        return ResponseEntity.ok(rolePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated RoleDto roleDto, @PathVariable("id") Integer id) {
        roleService.update(roleDto, id);
        return ResponseEntity.ok().build();
    }
}