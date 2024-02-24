package com.example.testfinal.controller;

import com.example.testfinal.entity.Party;
import com.example.testfinal.model.ItemNotExistException;
import com.example.testfinal.service.PartyService;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(value = RestApi.ROOT + "/party")
@CrossOrigin(origins = "*")
@RestController
public class PartyRestController {
    private final PartyService partyService;
   // private static final FluentLogger logger = FluentLogger.forEnclosingClass();
   // private static final Flogger logger=Flogger.class;// new Flogger();
    public PartyRestController(PartyService partyService) {
        this.partyService = partyService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> getAll()
            throws ItemNotExistException {
        return ResponseEntity.ok(partyService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") Long id)
            throws ItemNotExistException {
        return ResponseEntity.ok(partyService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> registerNewParty(@RequestBody Party party )
            throws ItemNotExistException {

        return ResponseEntity.ok(
                partyService.registerNewParty(party)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParty(@RequestBody Party party, @PathVariable Long id)
            throws ItemNotExistException {
        return ResponseEntity.ok(
                partyService.updateParty(party,id)
        );
    }

}
