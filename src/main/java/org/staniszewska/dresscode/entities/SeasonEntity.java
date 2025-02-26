package org.staniszewska.dresscode.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.staniszewska.dresscode.models.Season;

import java.util.Set;

@Setter
@Getter
@Entity
public class SeasonEntity {
    @Id
    @Enumerated
    private Season season;

    @JsonIgnore
    @ManyToMany(mappedBy = "seasons")
    private Set<ElementEntity> elements;

    @JsonIgnore
    @ManyToMany(mappedBy = "seasons")
    private Set<SetEntity> sets;
}
