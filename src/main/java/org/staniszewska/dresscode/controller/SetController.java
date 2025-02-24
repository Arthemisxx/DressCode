package org.staniszewska.dresscode.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.staniszewska.dresscode.entity.SetEntity;
import org.staniszewska.dresscode.model.SetDTO;
import org.staniszewska.dresscode.repository.SetRepository;
import org.staniszewska.dresscode.service.SetService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sets")
public class SetController {
    private final Logger logger = LogManager.getLogger(SetController.class);
    private final SetService setService;
    private final SetRepository setRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<SetDTO>> getSets() {
        var result = setService.findAll();
        if (result.isEmpty()) {
            logger.info("No set found!");
        } else {
            logger.info("All sets: ");
            result.forEach(e -> logger.info(e.toString()));
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<SetDTO> getSetById(@PathVariable Long id) {
        var result = setService.findById(id);
        if (result == null) {
            logger.info("Set with ID {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            logger.info("Set with ID {}:", id);
            logger.info(result.toString());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<Void> addSet(@RequestBody SetDTO setDTO) {
        logger.info("Adding set...");
        setService.addSet(setDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteSet(@PathVariable Long id) {
        logger.info("Deleting set...");
        SetEntity s = setRepository.findSetEntityById(id);
        if (s == null) {
            logger.info("Set not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            setService.deleteSet(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    public ResponseEntity<Void> updateSet(@PathVariable Long id, @RequestBody SetDTO setDTO){
        logger.info("Updating set...");
        setService.updateSet(id, setDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
