package com.digitalclick.finalproject.dto;

public class RoleDto extends AbstractDto<Integer> {
    private Integer id;
    private String name;

    public RoleDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}