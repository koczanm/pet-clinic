package pl.mateuszkoczan.petclinic.service.map;

import org.springframework.stereotype.Service;
import pl.mateuszkoczan.petclinic.model.Owner;
import pl.mateuszkoczan.petclinic.model.Pet;
import pl.mateuszkoczan.petclinic.model.Visit;
import pl.mateuszkoczan.petclinic.service.OwnerService;
import pl.mateuszkoczan.petclinic.service.PetService;
import pl.mateuszkoczan.petclinic.service.VisitService;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    private final OwnerService ownerService;
    private final PetService petService;

    public VisitMapService(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {

        if (object != null) {
            if (object.getPet() != null) {
                if (object.getPet().getOwner() != null) {
                    if (object.getPet().getOwner().getId() == null) {
                        Owner savedOwner = ownerService.save(object.getPet().getOwner());
                        object.getPet().setOwner(savedOwner);
                    }
                } else {
                    throw new RuntimeException("Owner Is Required");
                }

                if (object.getPet().getId() == null) {
                    Pet savedPet = petService.save(object.getPet());
                    object.getPet().setId(savedPet.getId());
                }
            } else {
                throw new RuntimeException("Pet Is Required");
            }

            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }
}
