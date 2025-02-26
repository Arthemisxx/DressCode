package org.staniszewska.dresscode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.staniszewska.dresscode.entities.ColorEntity;

@Repository
public interface ColorRepository extends CrudRepository<ColorEntity, String> {
}
