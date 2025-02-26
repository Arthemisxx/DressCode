package org.staniszewska.dresscode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.staniszewska.dresscode.entities.CreatorEntity;
import org.staniszewska.dresscode.models.Creator;

@Repository
public interface CreatorRepository extends CrudRepository<CreatorEntity, Creator> {
}
