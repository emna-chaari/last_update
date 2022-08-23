package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>, JpaSpecificationExecutor<Status> {
}