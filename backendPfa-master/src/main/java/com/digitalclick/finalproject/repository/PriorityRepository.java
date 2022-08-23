package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Integer>, JpaSpecificationExecutor<Priority> {
}