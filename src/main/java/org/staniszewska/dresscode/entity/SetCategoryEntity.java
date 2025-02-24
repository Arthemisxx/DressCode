package org.staniszewska.dresscode.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.staniszewska.dresscode.model.SetCategory;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class SetCategoryEntity {
    @Id
    @Enumerated
    private SetCategory setCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "setCategory")
    private Set<SetEntity> sets = new HashSet<>();
}
