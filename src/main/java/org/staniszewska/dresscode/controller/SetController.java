package org.staniszewska.dresscode.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.staniszewska.dresscode.model.SetDTO;
import org.staniszewska.dresscode.service.SetService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sets")
public class SetController {
    private final Logger logger = LogManager.getLogger(SetController.class);
    private final SetService setService;

    @GetMapping
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

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<Void> addSet(@RequestBody SetDTO setDTO){
        logger.info("Adding set...");
        setService.addSet(setDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
