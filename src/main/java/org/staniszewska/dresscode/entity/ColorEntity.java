package org.staniszewska.dresscode.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String color;

    @ManyToMany
    private List<ElementEntity> elementEntityList;
}
