package org.staniszewska.dresscode.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ElementDTO {
    private String name;
    private String description;
    private List<String> colorList;
    private List<Season> seasons;
    private String photo;
    private ElementCategory category;
}
