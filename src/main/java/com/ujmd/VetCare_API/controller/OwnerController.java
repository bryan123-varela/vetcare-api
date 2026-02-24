package com.ujmd.VetCare_API.controller;

import com.ujmd.VetCare_API.dto.CreateOwnerRequest;
import com.ujmd.VetCare_API.model.Owner;
import com.ujmd.VetCare_API.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public Owner create(@Valid @RequestBody CreateOwnerRequest request) {

        Owner owner = new Owner();
        owner.setNombre(request.getNombre());
        owner.setTelefono(request.getTelefono());

        return ownerService.create(owner);
    }

    @GetMapping
    public List<Owner> findAll() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    public Owner findById(@PathVariable Long id) {
        return ownerService.findById(id);
    }

    @PutMapping("/{id}")
    public Owner update(@PathVariable Long id,
                        @Valid @RequestBody CreateOwnerRequest request) {

        Owner owner = new Owner();
        owner.setNombre(request.getNombre());
        owner.setTelefono(request.getTelefono());

        return ownerService.update(id, owner);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ownerService.delete(id);
    }
}
