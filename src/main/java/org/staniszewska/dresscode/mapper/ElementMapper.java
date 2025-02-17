package org.staniszewska.dresscode.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.staniszewska.dresscode.entity.ColorEntity;
import org.staniszewska.dresscode.entity.ElementCategoryEntity;
import org.staniszewska.dresscode.entity.ElementEntity;
import org.staniszewska.dresscode.entity.SeasonEntity;
import org.staniszewska.dresscode.model.ElementCategory;
import org.staniszewska.dresscode.model.ElementDTO;
import org.staniszewska.dresscode.model.Season;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class ElementMapper {
    public ElementDTO toDTO(ElementEntity elementEntity){
        String name = elementEntity.getName();
        String description = elementEntity.getDescription();
        List<String> colorList = elementEntity.getColorList()
                .stream()
                .map(ColorEntity::getColor)
                .toList();
        List<Season> seasons = elementEntity.getSeasons()
                .stream()
                .map(SeasonEntity::getSeason)
                .toList();
        String photo =  elementEntity.getPhoto();
        ElementCategory category = elementEntity.getCategory().getElementCategory();

        return new ElementDTO(name, description, colorList, seasons, photo, category);
    }

    public ElementEntity toEntity(ElementDTO elementDTO){
        List<ColorEntity> colorList = elementDTO.getColorList()
                .stream()
                .map((x) -> {
                    var e = new ColorEntity();
                    e.setColor(x);
                    return e;
                })
                .toList();

        List<SeasonEntity> seasons = elementDTO.getSeasons()
                .stream()
                .map((x) -> {
                    var s = new SeasonEntity();
                    s.setSeason(x);
                    return s;
                })
                .toList();

        ElementCategoryEntity category = new ElementCategoryEntity();
        category.setElementCategory(elementDTO.getCategory());

        return new ElementEntity(elementDTO.getName(), elementDTO.getDescription(), elementDTO.getPhoto(), colorList, seasons, category);
    }
}
