package org.staniszewska.dresscode.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.staniszewska.dresscode.models.dtos.ElementDTO;
import org.staniszewska.dresscode.repositories.ElementRepository;
import org.staniszewska.dresscode.services.ElementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/elements")
public class ElementController {
    private final Logger logger = LogManager.getLogger(ElementController.class);
    private final ElementService elementService;
    private final ElementRepository elementRepository;

    @GetMapping
    public ResponseEntity<List<ElementDTO>> getElements() {
        var result = elementService.findAll();
        if (result.isEmpty()) {
            logger.info("No elements found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            logger.info("All elements:");
            result.forEach((e) -> logger.info(e.toString()));
            return new ResponseEntity<>(elementService.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ElementDTO> getElementById(@PathVariable Long id) {
        var result = elementService.findById(id);
        if (result == null) {
            logger.info("Element not found!!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            logger.info("Found element:");
            logger.info(result.toString());
            return new ResponseEntity<>(elementService.findById(id), HttpStatus.OK);
        }
    }

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<Void> addElement(@RequestBody ElementDTO elementDTO) {
        logger.info("Adding element...");
        elementService.addElement(elementDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteElement(@PathVariable Long id){
        logger.info("Deleting element...");
        var result = elementService.findById(id);
        if (result == null){
            logger.info("Element not found!!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            elementService.deleteElement(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    public ResponseEntity<Void> updateElement(@PathVariable Long id, @RequestBody ElementDTO elementDTO){
        logger.info("Updating element with id {}...", id);
        elementService.updateElement(id, elementDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
