package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.Ticket;
import com.digitalclick.finalproject.model.User;

import java.util.List;

public interface TicketRepositoryCustom {
    List<Ticket> findAllByAssignedTo(Integer assigned_to_id);
    List<Ticket> findAllByCreatedBy(Integer created_by_id);
    List<Ticket> findAllByRequestedBy(Integer requested_by_id);

    Ticket saveTicketByAssignedTo(Ticket entity, Integer assigned_to_id);
    Ticket saveTicketByCreatedBy(Ticket entity, Integer created_by_id);
    Ticket saveTicketByRequestedBy(Ticket entity, Integer requested_by_id);


}
