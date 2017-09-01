package com.residentevil.repositories;

import com.residentevil.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CapitalRepository extends JpaRepository<Capital, Long> {

    @Query(value = "SELECT c FROM Capital AS c")
    Set<Capital> findAllCapitals();

    Set<Capital> findAllByNameIn(String[] names);
}
