package org.staniszewska.dresscode.repository;

import org.springframework.data.repository.CrudRepository;
import org.staniszewska.dresscode.entity.SetEntity;

public interface SetRepository extends CrudRepository<SetEntity, Long> {
    SetEntity findSetEntityById(Long id);

}
