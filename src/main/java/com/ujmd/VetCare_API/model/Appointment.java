package com.ujmd.VetCare_API.model;

import java.time.LocalDateTime;

public class Appointment {

    private Long id;
    private Long petId;
    private LocalDateTime fecha;
    private String motivo;
    private AppointmentStatus estado;

    public Appointment() {
    }

    public Appointment(Long id, Long petId, LocalDateTime fecha,
                       String motivo, AppointmentStatus estado) {
        this.id = id;
        this.petId = petId;
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public AppointmentStatus getEstado() {
        return estado;
    }

    public void setEstado(AppointmentStatus estado) {
        this.estado = estado;
    }
}