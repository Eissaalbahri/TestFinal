package com.example.testfinal.service;

import com.example.testfinal.entity.Party;
import com.example.testfinal.model.PartyResource;
//import com.example.testfinal.repository.PartyRepository;

import java.util.List;

public interface PartyService {

    PartyResource registerNewParty(Party party);

    Object findById(Long id);

    List<PartyResource> getAll();

    PartyResource updateParty(Party party,Long id);
}
