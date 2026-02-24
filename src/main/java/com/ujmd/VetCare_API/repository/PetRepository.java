package com.ujmd.VetCare_API.repository;

import com.ujmd.VetCare_API.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class PetRepository {

    private final Map<Long, Pet> pets = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Pet save(Pet pet) {
        if (pet.getId() == null) {
            pet.setId(idGenerator.getAndIncrement());
        }
        pets.put(pet.getId(), pet);
        return pet;
    }

    public List<Pet> findAll() {
        return new ArrayList<>(pets.values());
    }

    public Optional<Pet> findById(Long id) {
        return Optional.ofNullable(pets.get(id));
    }

    public List<Pet> findByOwnerId(Long ownerId) {
        return pets.values()
                .stream()
                .filter(p -> p.getOwnerId().equals(ownerId))
                .collect(Collectors.toList());
    }
}
