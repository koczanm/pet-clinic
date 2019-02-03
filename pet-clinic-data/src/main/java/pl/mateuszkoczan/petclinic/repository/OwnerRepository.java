package pl.mateuszkoczan.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mateuszkoczan.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
