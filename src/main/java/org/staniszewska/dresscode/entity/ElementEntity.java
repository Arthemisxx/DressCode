package org.staniszewska.dresscode.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
    @JoinTable(
            name = "element_color",
            joinColumns = @JoinColumn(name = "element_id"),
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private Set<ColorEntity> colorList = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "element_season",
            joinColumns = @JoinColumn(name = "element_id"),
            inverseJoinColumns = @JoinColumn(name = "season_id")
    )
    private Set<SeasonEntity> seasons = new HashSet<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id", referencedColumnName = "elementCategory")
    private ElementCategoryEntity category;

    public ElementEntity() {}

    public ElementEntity(String name, String description, String photo, Set<ColorEntity> colorList, Set<SeasonEntity> seasons, ElementCategoryEntity category) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.colorList = colorList;
        this.seasons = seasons;
        this.category = category;
    }

    //TODO Add sets



}
