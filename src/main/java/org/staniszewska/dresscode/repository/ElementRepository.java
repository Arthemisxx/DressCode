package org.staniszewska.dresscode.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.staniszewska.dresscode.entity.ElementEntity;

public interface ElementRepository extends CrudRepository<ElementEntity, Long> {
    ElementEntity findElementEntityById(Long id);
}
