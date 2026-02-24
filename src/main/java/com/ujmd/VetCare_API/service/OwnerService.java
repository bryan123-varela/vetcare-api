package com.ujmd.VetCare_API.service;

import com.ujmd.VetCare_API.model.Owner;
import com.ujmd.VetCare_API.model.Pet;
import com.ujmd.VetCare_API.repository.OwnerRepository;
import com.ujmd.VetCare_API.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    public OwnerService(OwnerRepository ownerRepository,
                        PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
    }

    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner findById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner no encontrado"));
    }

    public Owner update(Long id, Owner updated) {
        Owner existing = findById(id);
        existing.setNombre(updated.getNombre());
        existing.setTelefono(updated.getTelefono());
        return ownerRepository.save(existing);
    }

    // REGLA 5: Si un dueño se elimina → mascotas inactivas
    public void delete(Long id) {
        Owner owner = findById(id);
        owner.setActivo(false);
        ownerRepository.save(owner);

        List<Pet> pets = petRepository.findByOwnerId(id);
        for (Pet pet : pets) {
            pet.setActivo(false);
            petRepository.save(pet);
        }
    }
}
