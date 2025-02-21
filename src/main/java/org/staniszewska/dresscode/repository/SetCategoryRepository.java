package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.SetCategoryEntity;
import org.staniszewska.dresscode.model.SetCategory;

public interface SetCategoryRepository extends CrudRepository<SetCategoryEntity, SetCategory> {
}
