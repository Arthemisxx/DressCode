package org.staniszewska.dresscode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ElementDTO {
    private Long id;
    private String name;
    private String description;
    private Set<String> colorList;
    private Set<Season> seasons;
    private String photo;
    private ElementCategory category;

    @Override
    public String toString() {
        return "ElementDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", colorList=" + colorList +
                ", seasons=" + seasons +
                ", category=" + category +
                '}';
    }

}
