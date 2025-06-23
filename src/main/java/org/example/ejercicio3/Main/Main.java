package org.example.ejercicio3.Main;

import org.example.ejercicio3.Modelo.Concursos;
import org.example.ejercicio3.Persistencia.RepositorioInscriptos;
import org.example.ejercicio3.UI.RadioCompetition;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {


            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {

                    System.out.println(e);
                }
            }
        });
    }

    private void start()  {
        new RadioCompetition(new Concursos(new RepositorioInscriptos()));

    }

}
