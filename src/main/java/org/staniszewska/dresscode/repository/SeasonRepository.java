package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.SeasonEntity;

public interface SeasonRepository extends CrudRepository<SeasonEntity, Long> {
}
