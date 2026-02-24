package com.ujmd.VetCare_API.service;

import com.ujmd.VetCare_API.model.*;
import com.ujmd.VetCare_API.repository.AppointmentRepository;
import com.ujmd.VetCare_API.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PetRepository petRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              PetRepository petRepository) {
        this.appointmentRepository = appointmentRepository;
        this.petRepository = petRepository;
    }

    // REGLA 2 y 3
    public Appointment create(Appointment appointment) {

        Pet pet = petRepository.findById(appointment.getPetId())
                .orElseThrow(() -> new RuntimeException("Pet no existe"));

        if (!pet.isActivo()) {
            throw new RuntimeException("Pet inactiva");
        }

        appointment.setEstado(AppointmentStatus.PROGRAMADA);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> findByPet(Long petId) {
        return appointmentRepository.findByPetId(petId);
    }

    // REGLA 4
    public Appointment changeStatus(Long id, AppointmentStatus nuevoEstado) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));

        if (appointment.getEstado() == AppointmentStatus.CANCELADA
                && nuevoEstado == AppointmentStatus.ATENDIDA) {
            throw new RuntimeException("No se puede cambiar una cita CANCELADA a ATENDIDA");
        }

        appointment.setEstado(nuevoEstado);
        return appointmentRepository.save(appointment);
    }
}
