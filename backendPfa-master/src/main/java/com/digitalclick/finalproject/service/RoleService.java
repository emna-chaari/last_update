package com.digitalclick.finalproject.service;

import com.digitalclick.finalproject.dto.RoleDto;
import com.digitalclick.finalproject.mapper.RoleMapper;
import com.digitalclick.finalproject.model.Role;
import com.digitalclick.finalproject.repository.RoleRepository;
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
public class RoleService {
    private final RoleRepository repository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository repository, RoleMapper roleMapper) {
        this.repository = repository;
        this.roleMapper = roleMapper;
    }

    public RoleDto save(RoleDto roleDto) {
        Role entity = roleMapper.toEntity(roleDto);


        entity.setId(roleDto.getId());
        entity.setName(roleDto.getName());

        return roleMapper.toDto(repository.save(entity));

    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


    public RoleDto findById(Integer id) {

        Role entity = repository.findById(id).orElse(null);
        RoleDto roleDto = roleMapper.toDto(entity);
        roleDto.setId(entity.getId());
        roleDto.setName(entity.getName());
        return roleDto;
    }

    public Page<RoleDto> findByCondition(RoleDto roleDto, Pageable pageable) {
        Page<Role> entityPage = repository.findAll(pageable);
        List<Role> entities = entityPage.getContent();
        return new PageImpl<>(roleMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public RoleDto update(RoleDto roleDto, Integer id) {
        RoleDto data = findById(id);
        Role entity = roleMapper.toEntity(roleDto);
        return save(roleMapper.toDto(entity));
    }
}