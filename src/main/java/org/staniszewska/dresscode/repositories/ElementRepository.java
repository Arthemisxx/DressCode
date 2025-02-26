package org.staniszewska.dresscode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.staniszewska.dresscode.entities.ElementEntity;

@Repository
public interface ElementRepository extends CrudRepository<ElementEntity, Long> {
    ElementEntity findElementEntityById(Long id);

    ElementEntity findElementEntityByName(String name);
}
