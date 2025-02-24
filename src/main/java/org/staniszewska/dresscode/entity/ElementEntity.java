package org.staniszewska.dresscode.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Set<ColorEntity> colorSet = new HashSet<>();

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

    public ElementEntity(Long id ,String name, String description, String photo, Set<ColorEntity> colorSet, Set<SeasonEntity> seasons, ElementCategoryEntity category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.colorSet = colorSet;
        this.seasons = seasons;
        this.category = category;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "elements")
    private Set<SetEntity> sets;

}
