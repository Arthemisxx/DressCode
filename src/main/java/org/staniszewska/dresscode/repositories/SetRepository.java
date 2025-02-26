package org.staniszewska.dresscode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.staniszewska.dresscode.entities.SetEntity;

@Repository
public interface SetRepository extends CrudRepository<SetEntity, Long> {
    SetEntity findSetEntityById(Long id);


    SetEntity findSetEntityByName(String name);

}
