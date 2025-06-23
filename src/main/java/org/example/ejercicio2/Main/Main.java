package org.example.ejercicio2.Main;

import org.example.ejercicio2.Modelo.RepositorioEmpleados;
import org.example.ejercicio2.Persistencia.ArchivoEmpleados;
import org.example.ejercicio2.Persistencia.ServicioEmail;
import org.example.ejercicio2.Servicio.ServicioSaludo;

public class Main {
    public static void main(String[] args) {
        var repo = new ArchivoEmpleados("empleados.txt");
        var mail = new ServicioEmail(
                "tu-email@mailtrap.io");
        var servicio = new ServicioSaludo(repo, mail);
        servicio.enviarSaludosDeCumpleaños();
    }
}
