package pl.mateuszkoczan.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mateuszkoczan.petclinic.model.Owner;
import pl.mateuszkoczan.petclinic.model.Pet;
import pl.mateuszkoczan.petclinic.model.PetType;
import pl.mateuszkoczan.petclinic.model.Vet;
import pl.mateuszkoczan.petclinic.service.OwnerService;
import pl.mateuszkoczan.petclinic.service.PetTypeService;
import pl.mateuszkoczan.petclinic.service.VetService;

import java.time.LocalDate;

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
        owner1.setAddress("123 Bickerer");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenine");
        owner2.setAddress("123 Bickerer");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123");

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

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDog);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDay(LocalDate.now());

        Pet fionasCat = new Pet();
        fionasCat.setName("Smiley");
        fionasCat.setPetType(savedCat);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDay(LocalDate.now());

        owner1.getPets().add(mikesPet);
        owner2.getPets().add(fionasCat);

        System.out.println("Loaded Pets");

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
