package pl.mateuszkoczan.petclinic.service;

import pl.mateuszkoczan.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Set<Vet> findAll();

    Vet save(Vet vet);
}
