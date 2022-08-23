package com.digitalclick.finalproject.dto;

import com.digitalclick.finalproject.model.StatusOfTicket;
import com.digitalclick.finalproject.model.TicketStatus;

import java.util.Date;

public class StatusDto extends AbstractDto<Integer> {
    private Integer id;
    private String description;
    private Date updateDate;
    private TicketStatus ticketStatus;
    private String author;

    public StatusOfTicket getStatusOfTicket() {
        return statusOfTicket;
    }

    public void setStatusOfTicket(StatusOfTicket statusOfTicket) {
        this.statusOfTicket = statusOfTicket;
    }

    private StatusOfTicket statusOfTicket;
  //  TicketStatus ticketStatus;
    public StatusDto() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}