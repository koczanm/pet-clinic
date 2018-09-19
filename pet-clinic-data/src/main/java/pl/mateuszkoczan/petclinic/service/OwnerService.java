package pl.mateuszkoczan.petclinic.service;

import pl.mateuszkoczan.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
