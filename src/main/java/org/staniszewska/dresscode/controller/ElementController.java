package org.staniszewska.dresscode.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.staniszewska.dresscode.model.ElementDTO;
import org.staniszewska.dresscode.service.ElementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/elements")
public class ElementController {
    private final Logger logger = LogManager.getLogger(ElementController.class);
    private final ElementService elementService;

    @GetMapping
    public ResponseEntity<List<ElementDTO>> getElements() {
        var result = elementService.findAll();
        if (result.isEmpty()) {
            logger.info("No elements found!");
        } else {
            logger.info("All elements:");
            result.forEach((e) -> logger.info(e.toString()));
        }
        return new ResponseEntity<>(elementService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ElementDTO> getElementById(@PathVariable("id") Long id) {
        var result = elementService.findById(id);
        if (result == null) {
            logger.info("Element not found!!");
            return new ResponseEntity<>(elementService.findById(id), HttpStatus.OK);
        } else {
            logger.info("Found element:");
            logger.info(result.toString());
            return null;
        }
    }

    @PostMapping(path = "/add", produces = "application/json")
    public ResponseEntity<Void> addElement(@RequestBody ElementDTO elementDTO) {
        logger.info("Adding element...");
        elementService.addElement(elementDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/delete", produces = "application/json")
    public ResponseEntity<Void> deleteElement(@PathVariable("id") Long id){
        logger.info("Deleting element...");
        elementService.deleteElement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
