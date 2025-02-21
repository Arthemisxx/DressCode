package org.staniszewska.dresscode.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.staniszewska.dresscode.entity.SetEntity;
import org.staniszewska.dresscode.mapper.SetMapper;
import org.staniszewska.dresscode.model.SetDTO;
import org.staniszewska.dresscode.repository.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SetService {
    public final Logger logger = LogManager.getLogger(SetService.class);
    private final SetRepository setRepository;
    private final SetMapper setMapper;
    private final CreatorRepository creatorRepository;
    private final SetCategoryRepository setCategoryRepository;
    private final SeasonRepository seasonRepository;
    private final ElementRepository elementRepository;
    private final ElementService elementService;

    public SetService(SetRepository setRepository, SetMapper setMapper, CreatorRepository creatorRepository, SetCategoryRepository setCategoryRepository, SeasonRepository seasonRepository, ElementRepository elementRepository, ElementService elementService) {
        this.setRepository = setRepository;
        this.setMapper = setMapper;
        this.creatorRepository = creatorRepository;
        this.setCategoryRepository = setCategoryRepository;
        this.seasonRepository = seasonRepository;
        this.elementRepository = elementRepository;
        this.elementService = elementService;
    }

    public List<SetDTO> findAll() {
        List<SetEntity> setEntityList = new ArrayList<>((Collection<? extends SetEntity>) setRepository.findAll());
        return setEntityList.stream()
                .map(setMapper::toDTO)
                .toList();
    }

    public void addSet(SetDTO setDTO) {
        SetEntity setEntity = setMapper.toEntity(setDTO);
        creatorRepository.save(setEntity.getCreator());
        setCategoryRepository.save(setEntity.getSetCategory());
        seasonRepository.saveAll(setEntity.getSeasons());
        setEntity.getElements().forEach(elementService::addElement);
        setRepository.save(setEntity);
        logger.info("Set added!");
    }
}
