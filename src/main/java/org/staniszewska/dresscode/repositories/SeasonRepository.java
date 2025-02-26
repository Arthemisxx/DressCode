package org.staniszewska.dresscode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.staniszewska.dresscode.entities.SeasonEntity;
import org.staniszewska.dresscode.models.Season;

@Repository
public interface SeasonRepository extends CrudRepository<SeasonEntity, Season> {
}
