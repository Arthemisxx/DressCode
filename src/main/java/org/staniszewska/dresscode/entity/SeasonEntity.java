package org.staniszewska.dresscode.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.staniszewska.dresscode.model.Season;

import java.util.List;

@Setter
@Getter
@Entity
public class SeasonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private Season season;

    @ManyToMany
    private List<ElementEntity> elementEntityList;
}
