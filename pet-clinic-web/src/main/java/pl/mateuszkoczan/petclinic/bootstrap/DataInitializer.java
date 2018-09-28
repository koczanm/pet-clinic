package pl.mateuszkoczan.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mateuszkoczan.petclinic.model.Owner;
import pl.mateuszkoczan.petclinic.model.PetType;
import pl.mateuszkoczan.petclinic.model.Vet;
import pl.mateuszkoczan.petclinic.service.OwnerService;
import pl.mateuszkoczan.petclinic.service.PetTypeService;
import pl.mateuszkoczan.petclinic.service.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final VetService vetService;

    public DataInitializer(OwnerService ownerService, PetTypeService petTypeService, VetService vetService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenine");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        System.out.println("Loaded Pet Types");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setFirstName("Rick");
        vet2.setLastName("Dickson");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
