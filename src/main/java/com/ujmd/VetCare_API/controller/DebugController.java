package com.ujmd.VetCare_API.controller;

import com.ujmd.VetCare_API.repository.AppointmentRepository;
import com.ujmd.VetCare_API.repository.OwnerRepository;
import com.ujmd.VetCare_API.repository.PetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/debug")
public class DebugController {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final AppointmentRepository appointmentRepository;

    public DebugController(OwnerRepository ownerRepository,
                           PetRepository petRepository,
                           AppointmentRepository appointmentRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/resumen")
    public Map<String, Object> resumen() {

        Map<String, Object> data = new HashMap<>();
        data.put("owners", ownerRepository.findAll());
        data.put("pets", petRepository.findAll());
        data.put("appointments", appointmentRepository.findAll());

        return data;
    }
}
