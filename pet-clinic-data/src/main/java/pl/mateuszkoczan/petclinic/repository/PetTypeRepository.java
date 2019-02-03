package pl.mateuszkoczan.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mateuszkoczan.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
