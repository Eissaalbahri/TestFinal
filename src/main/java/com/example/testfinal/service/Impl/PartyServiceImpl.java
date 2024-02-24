package com.example.testfinal.service.Impl;

import com.example.testfinal.entity.Party;
import com.example.testfinal.model.ItemNotExistException;
import com.example.testfinal.model.PartyResource;
import com.example.testfinal.repository.PartyRepository;
import com.example.testfinal.service.PartyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service(value = "partyService")
public class PartyServiceImpl implements PartyService {
    private final PartyRepository partyRepository;
    public PartyServiceImpl(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }
    @Override
    public PartyResource registerNewParty(Party Party){
        //throw new Exception("");
        return partyRepository.save(Party).toPartyResource();
    }

    @Override
    public PartyResource findById(Long PartyId){
        //Optional<Party> foundParty= PartyRepository.findById(PartyId);
        Optional<Party> foundParty = partyRepository.findById(PartyId);


        if (foundParty.isEmpty()) {
            throw new ItemNotExistException(String.format("Party with id %s not exist", PartyId));
        }

        return foundParty.get().toPartyResource();
    }

    @Override
    public List<PartyResource> getAll(){
        return partyRepository.findAll()
                .stream()
                .map(Party::toPartyResource)
                .collect(Collectors.toList());
    }

    @Override
    public PartyResource updateParty(Party Party,Long id){
        Party foundParty = partyRepository.findById(id)
                .orElseThrow(() -> new ItemNotExistException(
                        String.format("User with id %s not exist", id)));

        // TODO: 2021-08-17 14:47:00 check if email is unique among all users

        foundParty.setEmail(Party.getEmail());
        foundParty.setTitle(Party.getTitle());
        foundParty.setName(Party.getName());

        foundParty.setPhone(Party.getPhone());

        return partyRepository.save(foundParty).toPartyResource();
    }

}
