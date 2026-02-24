package com.ujmd.VetCare_API.controller;

import com.ujmd.VetCare_API.dto.ChangeAppointmentStatusRequest;
import com.ujmd.VetCare_API.dto.CreateAppointmentRequest;
import com.ujmd.VetCare_API.model.Appointment;
import com.ujmd.VetCare_API.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointments")
    public Appointment create(@Valid @RequestBody CreateAppointmentRequest request) {

        Appointment appointment = new Appointment();
        appointment.setPetId(request.getPetId());
        appointment.setFecha(request.getFecha());
        appointment.setMotivo(request.getMotivo());

        return appointmentService.create(appointment);
    }

    @GetMapping("/appointments")
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @PatchMapping("/appointments/{id}/estado")
    public Appointment changeStatus(@PathVariable Long id,
                                    @Valid @RequestBody ChangeAppointmentStatusRequest request) {

        return appointmentService.changeStatus(id, request.getEstado());
    }

    @GetMapping("/pets/{petId}/appointments")
    public List<Appointment> findByPet(@PathVariable Long petId) {
        return appointmentService.findByPet(petId);
    }
}