package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.SeasonEntity;
import org.staniszewska.dresscode.model.Season;

public interface SeasonRepository extends CrudRepository<SeasonEntity, Season> {
}
