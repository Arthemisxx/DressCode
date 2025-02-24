package org.staniszewska.dresscode.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.staniszewska.dresscode.entity.ElementEntity;
import org.staniszewska.dresscode.mapper.ElementMapper;
import org.staniszewska.dresscode.model.ElementDTO;
import org.staniszewska.dresscode.repository.CategoryRepository;
import org.staniszewska.dresscode.repository.ColorRepository;
import org.staniszewska.dresscode.repository.ElementRepository;
import org.staniszewska.dresscode.repository.SeasonRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        colorRepository.saveAll(elementEntity.getColorSet());
        categoryRepository.save(elementEntity.getCategory());
        seasonRepository.saveAll(elementEntity.getSeasons());
        elementRepository.save(elementEntity);
        logger.info("Element added!");
    }

    public void addElement(ElementEntity elementEntity){
        colorRepository.saveAll(elementEntity.getColorSet());
        categoryRepository.save(elementEntity.getCategory());
        seasonRepository.saveAll(elementEntity.getSeasons());
        elementRepository.save(elementEntity);
        logger.info("Element added!");
    }

    public List<ElementDTO> findAll(){
        List<ElementEntity> elements = new ArrayList<>((Collection<? extends ElementEntity>) elementRepository.findAll());
        return elements.stream()
                .map(elementMapper::toDTO)
                .toList();
    }

    public ElementDTO findById(Long id) {
            return elementMapper.toDTO(elementRepository.findElementEntityById(id));
    }

    public void deleteElement(Long id) {
            elementRepository.delete(elementRepository.findElementEntityById(id));
            logger.info("Element successfully deleted!");
    }

    public void updateElement(Long id, ElementDTO elementDTO) {
        ElementEntity updatedElement = elementMapper.toEntity(elementDTO);
        updatedElement.setId(id);
        colorRepository.saveAll(updatedElement.getColorSet());
        categoryRepository.save(updatedElement.getCategory());
        seasonRepository.saveAll(updatedElement.getSeasons());
        elementRepository.save(updatedElement);
        logger.info("Element updated successfully!");

    }
}
