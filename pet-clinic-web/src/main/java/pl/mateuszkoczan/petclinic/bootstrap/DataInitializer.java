package pl.mateuszkoczan.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mateuszkoczan.petclinic.model.*;
import pl.mateuszkoczan.petclinic.service.*;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VetService vetService;
    private final VisitService visitService;

    public DataInitializer(OwnerService ownerService, PetTypeService petTypeService,
                           SpecialtyService specialtyService, VetService vetService,
                           VisitService visitService) {
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.vetService = vetService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int counter = ownerService.findAll().size();

        if (counter == 0) {
            loadData();
        }
    }

    private void loadData() {
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

        Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sneezy Kitty");
        visit1.setPet(fionasCat);

        visitService.save(visit1);

        System.out.println("Loaded Visits");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialties");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rick");
        vet2.setLastName("Dickson");
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
