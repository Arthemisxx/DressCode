package org.staniszewska.dresscode.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.staniszewska.dresscode.entity.ColorEntity;
import org.staniszewska.dresscode.entity.ElementEntity;
import org.staniszewska.dresscode.mapper.ElementMapper;
import org.staniszewska.dresscode.model.ElementDTO;
import org.staniszewska.dresscode.repository.CategoryRepository;
import org.staniszewska.dresscode.repository.ColorRepository;
import org.staniszewska.dresscode.repository.ElementRepository;
import org.staniszewska.dresscode.repository.SeasonRepository;

@Service
@RequiredArgsConstructor
public class ElementService {
    private final Logger logger = LogManager.getLogger(ElementService.class);
    private final ElementRepository elementRepository;
    private final ColorRepository colorRepository;
    private final CategoryRepository categoryRepository;
    private final SeasonRepository seasonRepository;
    private final ElementMapper elementMapper;


    public void addElement(ElementDTO elementDTO){
        ElementEntity elementEntity = elementMapper.toEntity(elementDTO);
        colorRepository.saveAll(elementEntity.getColorList());
        categoryRepository.save(elementEntity.getCategory());
        seasonRepository.saveAll(elementEntity.getSeasons());
        elementRepository.save(elementEntity);
        logger.info("Element added!");
    }

}
