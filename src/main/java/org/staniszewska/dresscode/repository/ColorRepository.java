package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.ColorEntity;

public interface ColorRepository extends CrudRepository<ColorEntity, Long> {
}
