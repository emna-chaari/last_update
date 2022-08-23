package com.digitalclick.finalproject.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
    @Table(name = "ticket")
    public class Ticket {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column (name="ticket_id")
        private Integer id;

        @NotNull
       // @Size(min=1, max=50, message = "Title too long (max 50 characters)")
        private String title;

        @NotNull
        //@Size(min=1, max=500, message = "Description too long (max 500 characters)")
        private String description;

        @CreatedDate
        @Temporal(TemporalType.TIMESTAMP)
        private Date dateOpened;

        private Date dateClosed;

        @UpdateTimestamp
        @Temporal(TemporalType.TIMESTAMP)
        private Date lastUpdated;

        @OneToMany (cascade=CascadeType.ALL)
        @JoinColumn(name="ticket_id", referencedColumnName="ticket_id")
        private List<Status> updates;


        @ManyToOne
        private Type type;

        @ManyToOne
        private Category category;
        @ManyToOne
        @CreatedBy
        private User createdBy;

        @ManyToOne
        private User requestedBy;

        @ManyToOne
        private User assignedTo;

       private TicketStatus ticketStatus;
        @ManyToOne
        private Priority priority;

        @ManyToOne
        private StatusOfTicket statusOfTicket;

    public StatusOfTicket getStatusOfTicket() {
        return statusOfTicket;
    }

    public void setStatusOfTicket(StatusOfTicket statusOfTicket) {
        this.statusOfTicket = statusOfTicket;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Date getDateOpened() {
            return dateOpened;
        }

        public void setDateOpened(Date dateOpened) {
            this.dateOpened = dateOpened;
        }

        public Date getDateClosed() {
            return dateClosed;
        }

        public void setDateClosed(Date dateClosed) {
            this.dateClosed = dateClosed;
        }

        public Date getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(Date lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public User getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(User createdBy) {
            this.createdBy = createdBy;
        }

        public User getAssignedTo() {
            return assignedTo;
        }

        public void setAssignedTo(User assignedTo) {
            this.assignedTo = assignedTo;
        }

        public TicketStatus getTicketStatus() {
            return ticketStatus;
        }

        public void setTicketStatus(TicketStatus ticketStatus) {
            this.ticketStatus = ticketStatus;
        }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Status> getUpdates() {
        return updates;
    }

    public void setUpdates(List<Status> updates) {
        this.updates = updates;
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
