package org.staniszewska.dresscode.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.staniszewska.dresscode.model.ElementCategory;

import java.util.List;

@Setter
@Getter
@Entity
public class ElementCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private ElementCategory elementCategory;

    @OneToMany
    private List<ElementEntity> elementEntityList;
}
