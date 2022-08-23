package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.StatusOfTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOfTicketRepository extends JpaRepository<StatusOfTicket, Integer>, JpaSpecificationExecutor<StatusOfTicket> {
}