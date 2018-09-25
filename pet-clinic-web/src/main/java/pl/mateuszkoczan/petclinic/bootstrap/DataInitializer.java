package pl.mateuszkoczan.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mateuszkoczan.petclinic.model.Owner;
import pl.mateuszkoczan.petclinic.model.Vet;
import pl.mateuszkoczan.petclinic.service.OwnerService;
import pl.mateuszkoczan.petclinic.service.VetService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenine");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Rick");
        vet2.setLastName("Dickson");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
