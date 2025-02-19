package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.ElementCategoryEntity;
import org.staniszewska.dresscode.model.ElementCategory;

public interface CategoryRepository extends CrudRepository<ElementCategoryEntity, ElementCategory> {
}
