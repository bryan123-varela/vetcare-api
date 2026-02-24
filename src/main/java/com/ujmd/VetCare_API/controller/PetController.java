package com.ujmd.VetCare_API.controller;

import com.ujmd.VetCare_API.dto.CreatePetRequest;
import com.ujmd.VetCare_API.model.Pet;
import com.ujmd.VetCare_API.service.PetService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/pets")
    public Pet create(@Valid @RequestBody CreatePetRequest request) {

        Pet pet = new Pet();
        pet.setOwnerId(request.getOwnerId());
        pet.setNombre(request.getNombre());
        pet.setTipo(request.getTipo());
        pet.setEdad(request.getEdad());

        return petService.create(pet);
    }

    @GetMapping("/pets")
    public List<Pet> findAll() {
        return petService.findAll();
    }

    @GetMapping("/pets/{id}")
    public Pet findById(@PathVariable Long id) {
        return petService.findById(id);
    }

    @GetMapping("/owners/{ownerId}/pets")
    public List<Pet> findByOwner(@PathVariable Long ownerId) {
        return petService.findByOwner(ownerId);
    }

    @DeleteMapping("/pets/{id}")
    public void delete(@PathVariable Long id) {
        petService.delete(id);
    }
}