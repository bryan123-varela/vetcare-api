package com.ujmd.VetCare_API.model;

public class Owner {

    private Long id;
    private String nombre;
    private String telefono;
    private boolean activo = true;

    public Owner() {
    }

    public Owner(Long id, String nombre, String telefono, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
