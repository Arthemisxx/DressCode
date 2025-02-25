package org.staniszewska.dresscode.entities;
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
    @ManyToMany(mappedBy = "colorSet")
    private Set<ElementEntity> elementEntityList;
}
