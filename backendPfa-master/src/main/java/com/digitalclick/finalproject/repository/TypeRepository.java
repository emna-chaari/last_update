package com.digitalclick.finalproject.repository;

import com.digitalclick.finalproject.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer>, JpaSpecificationExecutor<Type> {
}