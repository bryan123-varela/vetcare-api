package com.ujmd.VetCare_API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CreateAppointmentRequest {

    @NotNull(message = "petId es obligatorio")
    private Long petId;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fecha;

    @NotBlank(message = "El motivo es obligatorio")
    @Size(min = 5, message = "El motivo debe tener mínimo 5 caracteres")
    private String motivo;

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
}