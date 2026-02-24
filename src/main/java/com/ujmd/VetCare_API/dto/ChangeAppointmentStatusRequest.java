package com.ujmd.VetCare_API.dto;

import com.ujmd.VetCare_API.model.AppointmentStatus;
import jakarta.validation.constraints.NotNull;

public class ChangeAppointmentStatusRequest {

    @NotNull(message = "El estado es obligatorio")
    private AppointmentStatus estado;

    public AppointmentStatus getEstado() {
        return estado;
    }

    public void setEstado(AppointmentStatus estado) {
        this.estado = estado;
    }
}
