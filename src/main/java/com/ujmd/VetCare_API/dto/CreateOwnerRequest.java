package com.ujmd.VetCare_API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateOwnerRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, message = "El nombre debe tener mínimo 3 caracteres")
    private String nombre;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 8, message = "El teléfono debe tener mínimo 8 caracteres")
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}