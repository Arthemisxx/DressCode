package org.staniszewska.dresscode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.staniszewska.dresscode.entities.ElementCategoryEntity;
import org.staniszewska.dresscode.models.ElementCategory;

@Repository
public interface CategoryRepository extends CrudRepository<ElementCategoryEntity, ElementCategory> {
}
