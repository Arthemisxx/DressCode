package org.staniszewska.dresscode.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class ElementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 400)
    private String description;
    @Lob
    private String photo;

    @ManyToMany
    private List<ColorEntity> colorList;

    @ManyToMany
    private List<SeasonEntity> seasons;

    @ManyToOne
    private ElementCategoryEntity category;

    public ElementEntity() {}

    public ElementEntity(String name, String description, String photo, List<ColorEntity> colorList, List<SeasonEntity> seasons, ElementCategoryEntity category) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.colorList = colorList;
        this.seasons = seasons;
        this.category = category;
    }



    //TODO Add sets



}
