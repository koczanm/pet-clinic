package pl.mateuszkoczan.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mateuszkoczan.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
