package org.example.ejercicio2.Servicio;

import org.example.ejercicio2.Modelo.Empleado;
import org.example.ejercicio2.Modelo.EnvioMensaje;
import org.example.ejercicio2.Modelo.RepositorioEmpleados;
import org.example.ejercicio2.Persistencia.ServicioEmail;

import java.time.LocalDate;
import java.util.List;

public class ServicioSaludo {
    private RepositorioEmpleados repo;
    private EnvioMensaje mail;

    public ServicioSaludo(RepositorioEmpleados repo, EnvioMensaje mail) {
        this.repo = repo;
        this.mail = mail;
    }

    public void enviarSaludosDeCumpleaños() {
        List<Empleado> empleados = repo.obtenerEmpleados();
        LocalDate hoy = LocalDate.now();

        for (Empleado e : empleados) {
            if (e.cumpleHoy(hoy)) {
                mail.enviarEmail(e.getEmail(), "Feliz cumpleaños", "Feliz cumpleaños " + e.nombreCompleto() + "!");
                ;
            }
        }
    }
}
