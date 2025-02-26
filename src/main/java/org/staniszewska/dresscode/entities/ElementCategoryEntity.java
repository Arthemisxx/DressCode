package org.staniszewska.dresscode.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.staniszewska.dresscode.models.ElementCategory;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
public class ElementCategoryEntity {
    @Id
    @Enumerated
    private ElementCategory elementCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<ElementEntity> elements = new HashSet<>();
}
