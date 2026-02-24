package com.ujmd.VetCare_API.model;

public class Pet {

    private Long id;
    private Long ownerId;
    private String nombre;
    private PetType tipo;
    private int edad;
    private boolean activo = true;

    public Pet() {
    }

    public Pet(Long id, Long ownerId, String nombre, PetType tipo, int edad, boolean activo) {
        this.id = id;
        this.ownerId = ownerId;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
