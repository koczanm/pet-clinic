package pl.mateuszkoczan.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mateuszkoczan.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
