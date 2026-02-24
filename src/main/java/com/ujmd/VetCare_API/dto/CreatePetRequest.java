package com.ujmd.VetCare_API.dto;

import com.ujmd.VetCare_API.model.PetType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatePetRequest {

    @NotNull(message = "ownerId es obligatorio")
    private Long ownerId;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "El tipo es obligatorio")
    private PetType tipo;

    @Min(value = 0, message = "La edad no puede ser negativa")
    private int edad;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PetType getTipo() {
        return tipo;
    }

    public void setTipo(PetType tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}