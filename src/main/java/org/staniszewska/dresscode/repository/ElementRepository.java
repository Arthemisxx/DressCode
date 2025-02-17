package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.ElementEntity;

public interface ElementRepository extends CrudRepository<ElementEntity, Long> {

    ElementEntity findElementEntityById(Long id);


}
