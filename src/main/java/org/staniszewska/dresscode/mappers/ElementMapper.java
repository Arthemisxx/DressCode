package org.staniszewska.dresscode.mappers;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.staniszewska.dresscode.entities.ColorEntity;
import org.staniszewska.dresscode.entities.ElementCategoryEntity;
import org.staniszewska.dresscode.entities.ElementEntity;
import org.staniszewska.dresscode.entities.SeasonEntity;
import org.staniszewska.dresscode.models.ElementCategory;
import org.staniszewska.dresscode.models.dtos.ElementDTO;
import org.staniszewska.dresscode.models.Season;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class ElementMapper {
    public ElementDTO toDTO(ElementEntity elementEntity) {
        Long id = elementEntity.getId();
        String name = elementEntity.getName();
        String description = elementEntity.getDescription();
        Set<String> colorSet = elementEntity.getColorSet()
                .stream()
                .map(ColorEntity::getColor)
                .collect(Collectors.toSet());
        Set<Season> seasons = elementEntity.getSeasons()
                .stream()
                .map(SeasonEntity::getSeason)
                .collect(Collectors.toSet());
        String photo = elementEntity.getPhoto();
        ElementCategory category = elementEntity.getCategory().getElementCategory();

        return new ElementDTO(id, name, description, colorSet, seasons, photo, category);
    }

    public ElementEntity toEntity(ElementDTO elementDTO) {
        Set<ColorEntity> colorSet = elementDTO.getColorList()
                .stream()
                .map((x) -> {
                    var e = new ColorEntity();
                    e.setColor(x);
                    return e;
                })
                .collect(Collectors.toSet());

        Set<SeasonEntity> seasons = elementDTO.getSeasons()
                .stream()
                .map((x) -> {
                    var s = new SeasonEntity();
                    s.setSeason(x);
                    return s;
                })
                .collect(Collectors.toSet());
        ElementCategoryEntity category = new ElementCategoryEntity();
        category.setElementCategory(elementDTO.getCategory());

        return new ElementEntity(elementDTO.getId(), elementDTO.getName(), elementDTO.getDescription(), elementDTO.getPhoto(), colorSet, seasons, category);
    }
}
