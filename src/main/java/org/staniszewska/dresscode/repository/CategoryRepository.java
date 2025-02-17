package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.ElementCategoryEntity;

public interface CategoryRepository extends CrudRepository<ElementCategoryEntity, Long> {
}
