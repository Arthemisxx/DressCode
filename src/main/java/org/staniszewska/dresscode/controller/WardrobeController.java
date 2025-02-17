package org.staniszewska.dresscode.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.staniszewska.dresscode.entity.ElementEntity;
import org.staniszewska.dresscode.mapper.ElementMapper;
import org.staniszewska.dresscode.model.ElementDTO;
import org.staniszewska.dresscode.service.ElementService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wardrobe")
public class WardrobeController {
    private final Logger logger = LogManager.getLogger(WardrobeController.class);
    private final ElementService elementService;

    @PostMapping(path = "/add",produces = "application/json")
    public ResponseEntity<Void> addElement(@RequestBody ElementDTO elementDTO){
        logger.info("Adding element...");
        elementService.addElement(elementDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
