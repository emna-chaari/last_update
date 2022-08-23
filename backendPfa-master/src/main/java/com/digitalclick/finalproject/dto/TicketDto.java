package com.digitalclick.finalproject.dto;

import com.digitalclick.finalproject.model.*;

import java.util.Date;
import java.util.List;

public class TicketDto extends AbstractDto<Integer> {
    private Integer id;
    private String title;
    private String description;

    private Date dateOpened;

    private Date dateClosed;
    private Date lastUpdated;
    private List<Status> updates;
    private User createdBy;
    private User assignedTo;
    private User requestedBy;

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    private TicketStatus ticketStatus;

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    private Category category;
    private Priority priority;
    private Type type;
    private StatusOfTicket statusOfTicket;
    public TicketDto() {
    }

    public StatusOfTicket getStatusOfTicket() {
        return statusOfTicket;
    }

    public void setStatusOfTicket(StatusOfTicket statusOfTicket) {
        this.statusOfTicket = statusOfTicket;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDateOpened(java.util.Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public java.util.Date getDateOpened() {
        return this.dateOpened;
    }

    public void setDateClosed(java.util.Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public java.util.Date getDateClosed() {
        return this.dateClosed;
    }

    public void setLastUpdated(java.util.Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public java.util.Date getLastUpdated() {
        return this.lastUpdated;
    }

    public void setUpdates(java.util.List<com.digitalclick.finalproject.model.Status> updates) {
        this.updates = updates;
    }

    public java.util.List<com.digitalclick.finalproject.model.Status> getUpdates() {
        return this.updates;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public User getAssignedTo() {
        return this.assignedTo;
    }
/*
    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public TicketStatus getTicketStatus() {
        return this.ticketStatus;
    }*/

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}