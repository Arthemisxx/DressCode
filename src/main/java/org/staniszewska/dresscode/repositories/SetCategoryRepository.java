package org.staniszewska.dresscode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.staniszewska.dresscode.entities.SetCategoryEntity;
import org.staniszewska.dresscode.models.SetCategory;

@Repository
public interface SetCategoryRepository extends CrudRepository<SetCategoryEntity, SetCategory> {
}
