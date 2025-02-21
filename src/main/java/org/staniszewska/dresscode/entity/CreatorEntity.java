package org.staniszewska.dresscode.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.staniszewska.dresscode.model.Creator;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class CreatorEntity {
    @Id
    @Enumerated
    private Creator creator;

    @JsonIgnore
    @OneToMany(mappedBy = "creator")
    private Set<SetEntity> sets = new HashSet<>();


}
