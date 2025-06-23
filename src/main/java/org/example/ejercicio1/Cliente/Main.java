package org.example.ejercicio1.Cliente;

import org.example.ejercicio1.Persistencia.BaseDeDatos;
import org.example.ejercicio1.Servicio.Servicio;
import org.example.ejercicio1.UI.AgregarParticipante;

import javax.swing.*;
import java.sql.SQLException;


public class Main {

        public static void main (String[]args){
        SwingUtilities.invokeLater(() -> {
            try {
                var repo = new BaseDeDatos();
                var servicio = new Servicio(repo);
                new AgregarParticipante(servicio);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error de conexión a base de datos: " + e.getMessage());
            }
        });
    }
    }