package org.staniszewska.dresscode.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class SetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(length = 400)
    private String description;
    @Lob
    private String photo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "creator_id", referencedColumnName = "creator")
    private CreatorEntity creator;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "setCategory_id", referencedColumnName = "setCategory")
    private SetCategoryEntity setCategory;

    @ManyToMany
    @JoinTable(
            name = "set_season",
            joinColumns = @JoinColumn(name = "set_id"),
            inverseJoinColumns = @JoinColumn(name = "season_id")
    )
    private Set<SeasonEntity> seasons = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "set_element",
            joinColumns = @JoinColumn(name = "set_id"),
            inverseJoinColumns = @JoinColumn(name = "element_id")
    )
    private Set<ElementEntity> elements = new HashSet<>();

    public SetEntity() {}

    public SetEntity(String name, String description, String photo, CreatorEntity creator, SetCategoryEntity category, Set<SeasonEntity> seasons, Set<ElementEntity> elements) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.creator = creator;
        this.setCategory = category;
        this.seasons = seasons;
        this.elements = elements;
    }


}
