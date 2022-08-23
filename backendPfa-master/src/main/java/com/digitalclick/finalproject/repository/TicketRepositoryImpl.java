package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.Ticket;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TicketRepositoryImpl implements  TicketRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Ticket> findAllByAssignedTo(Integer assigned_to_id) {
        Query query = (Query) entityManager.createNativeQuery("SELECT T.* FROM ticket as T where T.assigned_to_id = ?",Ticket.class);
        query.setParameter(1,assigned_to_id);
        return query.getResultList();
    }

    @Override
    public List<Ticket> findAllByCreatedBy(Integer created_by_id) {
        Query query = (Query) entityManager.createNativeQuery("SELECT T.* FROM ticket as T where T.created_by_id = ?",Ticket.class);
        query.setParameter(1,created_by_id);
        return query.getResultList();
    }

    @Override
    public List<Ticket> findAllByRequestedBy(Integer requested_by_id) {
        Query query = (Query) entityManager.createNativeQuery("SELECT T.* FROM ticket as T where T.requested_by_id = ?",Ticket.class);
        query.setParameter(1,requested_by_id);
        return query.getResultList();
    }

    public Ticket saveTicketByAssignedTo(Ticket entity, Integer assigned_to_id) {
        Query query = (Query) entityManager.createNativeQuery("INSERT INTO ticket VALUES (?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?)");
        query.setParameter(1,entity.getId());
        query.setParameter(2, entity.getTitle());
        query.setParameter(3, entity.getDescription());
        query.setParameter(4, entity.getDateOpened());
        query.setParameter(5, entity.getDateClosed());
        query.setParameter(6, entity.getLastUpdated());
        query.setParameter(7, entity.getUpdates());
        query.setParameter(8, entity.getType());
        query.setParameter(9, entity.getCategory());
        query.setParameter(10, entity.getTicketStatus());
        query.setParameter(11, entity.getPriority());
        query.setParameter(12, entity.getCreatedBy());
        query.setParameter(13, entity.getRequestedBy());
        query.setParameter(14, entity.getStatusOfTicket());
        query.setParameter(15, assigned_to_id);
        query.executeUpdate();
        return entity;
    }

    public Ticket saveTicketByCreatedBy(Ticket entity, Integer created_by_id) {
        Query query = (Query) entityManager.createNativeQuery("INSERT INTO ticket VALUES (?,?, ?,  ?, ?, ?, ?,?, ?, ?, ?, ?, ?)");
        query.setParameter(1,entity.getId());
        query.setParameter(2, entity.getTitle());
        query.setParameter(3, entity.getDescription());
        query.setParameter(4, entity.getDateOpened());
        query.setParameter(5, entity.getDateClosed());
        query.setParameter(6, entity.getLastUpdated());
        query.setParameter(7, entity.getUpdates());
        query.setParameter(8, entity.getType());
        query.setParameter(9, entity.getCategory());
        query.setParameter(10, entity.getTicketStatus());
        query.setParameter(11, entity.getPriority());
        query.setParameter(12, entity.getAssignedTo());
        query.setParameter(13, entity.getRequestedBy());
        query.setParameter(14, entity.getStatusOfTicket());

        query.setParameter(15, created_by_id);
        query.executeUpdate();
        return entity;
    }

    public Ticket saveTicketByRequestedBy(Ticket entity, Integer requested_by_id) {
        Query query = (Query) entityManager.createNativeQuery("INSERT INTO ticket VALUES (?,?, ?, ?, ?, ?, ?, ?,?, ?,  ?, ?, ?)");
        query.setParameter(1,entity.getId());
        query.setParameter(2, entity.getTitle());
        query.setParameter(3, entity.getDescription());
        query.setParameter(4, entity.getDateOpened());
        query.setParameter(5, entity.getDateClosed());
        query.setParameter(6, entity.getLastUpdated());
        query.setParameter(7, entity.getUpdates());
        query.setParameter(8, entity.getType());
        query.setParameter(9, entity.getCategory());
       query.setParameter(10, entity.getTicketStatus());
        query.setParameter(11, entity.getPriority());
        query.setParameter(12, entity.getCreatedBy());
        query.setParameter(13, entity.getAssignedTo());
        query.setParameter(14, entity.getStatusOfTicket());

        query.setParameter(15, requested_by_id);
        query.executeUpdate();
        return entity;
    }












}
