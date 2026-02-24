package com.ujmd.VetCare_API.service;

import com.ujmd.VetCare_API.model.Owner;
import com.ujmd.VetCare_API.model.Pet;
import com.ujmd.VetCare_API.repository.OwnerRepository;
import com.ujmd.VetCare_API.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;

    public PetService(PetRepository petRepository,
                      OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }

    // REGLA 1: No crear mascota si dueño no existe o está inactivo
    public Pet create(Pet pet) {

        Owner owner = ownerRepository.findById(pet.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner no existe"));

        if (!owner.isActivo()) {
            throw new RuntimeException("Owner inactivo");
        }

        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet no encontrada"));
    }

    public List<Pet> findByOwner(Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    public void delete(Long id) {
        Pet pet = findById(id);
        pet.setActivo(false);
        petRepository.save(pet);
    }
}