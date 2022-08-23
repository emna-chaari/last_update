package com.digitalclick.finalproject.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "status")
    public class Status {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="status_id")
        private Integer id;


        private String description;

        @CreationTimestamp
        @Temporal(TemporalType.TIMESTAMP)
        private Date updateDate;

        private String author;
        private TicketStatus ticketStatus;
        public Status() {

        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Date getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

