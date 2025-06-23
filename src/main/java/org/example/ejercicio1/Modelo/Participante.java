package org.example.ejercicio1.Modelo;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("Debe cargar un nombre");
        if (telefono == null || telefono.isEmpty())
            throw new IllegalArgumentException("Debe cargar un telefono");
        if (!telefono.matches("\\d{4}-\\d{6}"))
            throw new IllegalArgumentException("El teléfono debe ingresarse de la forma: NNNN-NNNNNN");
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))
            throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegion() {
        return region;
    }
}
