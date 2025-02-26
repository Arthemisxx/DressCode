package org.staniszewska.dresscode.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.staniszewska.dresscode.models.Creator;
import org.staniszewska.dresscode.models.Season;
import org.staniszewska.dresscode.models.SetCategory;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SetDTO {
    private String name;
    private String description;
    private String photo;
    private Creator creator;
    private SetCategory category;
    private Set<Season> seasons;
    private Set<ElementDTO> elements;

    @Override
    public String toString() {
        return "SetDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", seasons=" + seasons +
                ", category=" + category +
                ", creator=" + creator +
                ", elements=" + elements +
                '}';
    }
}
