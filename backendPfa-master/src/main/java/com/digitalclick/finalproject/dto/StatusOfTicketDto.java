package com.digitalclick.finalproject.dto;

public class StatusOfTicketDto extends AbstractDto<Integer> {
    private Integer id;
    private String name;

    public StatusOfTicketDto() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}