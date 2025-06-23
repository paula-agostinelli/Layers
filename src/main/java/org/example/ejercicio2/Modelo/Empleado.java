package org.example.ejercicio2.Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado {
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;

    public Empleado(String apellido, String nombre, String fechaNacimientoStr, String email) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        this.email = email;
    }

    public boolean cumpleHoy(LocalDate hoy) {
        return fechaNacimiento.getMonth() == hoy.getMonth()
                && fechaNacimiento.getDayOfMonth() == hoy.getDayOfMonth();
    }

    public String nombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getEmail() {
        return email;
    }
}
