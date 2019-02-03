package pl.mateuszkoczan.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mateuszkoczan.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
