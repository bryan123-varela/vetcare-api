package com.ujmd.VetCare_API.repository;

import com.ujmd.VetCare_API.model.Appointment;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class AppointmentRepository {

    private final Map<Long, Appointment> appointments = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Appointment save(Appointment appointment) {
        if (appointment.getId() == null) {
            appointment.setId(idGenerator.getAndIncrement());
        }
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(appointments.values());
    }

    public Optional<Appointment> findById(Long id) {
        return Optional.ofNullable(appointments.get(id));
    }

    public List<Appointment> findByPetId(Long petId) {
        return appointments.values()
                .stream()
                .filter(a -> a.getPetId().equals(petId))
                .collect(Collectors.toList());
    }
}