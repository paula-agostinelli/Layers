package org.example.ejercicio1.Servicio;

import org.example.ejercicio1.Modelo.Participante;
import org.example.ejercicio1.Modelo.RepositorioParticipante;

public class Servicio {
    private RepositorioParticipante repo;

    public Servicio (RepositorioParticipante repo) {
        this.repo = repo;
    }

    public void registrarParticipante(String nombre, String telefono, String region) {
        Participante participante = new Participante(nombre, telefono, region);
        repo.guardar(participante);
    }
}
