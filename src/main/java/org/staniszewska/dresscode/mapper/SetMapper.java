package org.staniszewska.dresscode.mapper;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.staniszewska.dresscode.entity.*;
import org.staniszewska.dresscode.model.*;
import org.staniszewska.dresscode.repository.ElementRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SetMapper {
    private final ElementMapper elementMapper;
    private final ElementRepository elementRepository;

    public SetDTO toDTO(SetEntity setEntity) {
        String name = setEntity.getName();
        String description = setEntity.getDescription();
        String photo = setEntity.getPhoto();
        Creator creator = setEntity.getCreator().getCreator();
        SetCategory category = setEntity.getSetCategory().getSetCategory();
        Set<Season> seasons = setEntity.getSeasons()
                .stream()
                .map(SeasonEntity::getSeason)
                .collect(Collectors.toSet());
        Set<ElementDTO> elements = setEntity.getElements()
                .stream()
                .map(elementMapper::toDTO)
                .collect(Collectors.toSet());

        return new SetDTO(name, description, photo, creator, category, seasons, elements);
    }


    public SetEntity toEntity(SetDTO setDTO) {
        String name = setDTO.getName();
        String description = setDTO.getDescription();
        String photo = setDTO.getPhoto();
        CreatorEntity creator = new CreatorEntity();
        creator.setCreator(setDTO.getCreator());
        SetCategoryEntity category = new SetCategoryEntity();
        category.setSetCategory(setDTO.getCategory());

        Set<SeasonEntity> seasons = setDTO.getSeasons()
                .stream()
                .map(x -> {
                    var s = new SeasonEntity();
                    s.setSeason(x);
                    return s;
                })
                .collect(Collectors.toSet());

        var existingEntities = setDTO.getElements().stream().filter(elementDTO -> elementDTO.getId() != null)
                .map(elementDTO -> elementRepository.findById(elementDTO.getId())).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());


        Set<ElementEntity> elements = setDTO.getElements()
                .stream()
                .filter(elementDTO -> elementDTO.getId() == null)
                .map(elementMapper::toEntity)
                .collect(Collectors.toSet());

        elements.addAll(existingEntities);

        return new SetEntity(name, description, photo, creator, category, seasons, elements);
    }


}
