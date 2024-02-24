package com.example.testfinal.repository;

import com.example.testfinal.entity.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartyRepository extends CrudRepository<Party,Long> {
    Optional<Party> findByEmail(String email);

    List<Party> findAll();
}
