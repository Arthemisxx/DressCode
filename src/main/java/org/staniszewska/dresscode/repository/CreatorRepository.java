package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.CreatorEntity;
import org.staniszewska.dresscode.model.Creator;

public interface CreatorRepository extends CrudRepository<CreatorEntity, Creator> {
}
