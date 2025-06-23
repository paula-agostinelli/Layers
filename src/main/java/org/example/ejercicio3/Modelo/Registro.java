package org.example.ejercicio3.Modelo;

import java.util.ArrayList;

public interface Registro {
    void guardar(String apellido, String nombre, String telefono, String email, String idPersona, String idConcurso);
    ArrayList<Concurso> todosLosConcursos();
}
