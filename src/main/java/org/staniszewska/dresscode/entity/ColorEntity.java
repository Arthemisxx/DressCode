package org.staniszewska.dresscode.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@Entity
public class ColorEntity {
    @Id
    private String color;

    @JsonIgnore
    @ManyToMany(mappedBy = "colorList")
    private Set<ElementEntity> elementEntityList;
}
