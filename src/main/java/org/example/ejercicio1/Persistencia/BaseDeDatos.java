package org.example.ejercicio1.Persistencia;

import org.example.ejercicio1.Modelo.Participante;
import org.example.ejercicio1.Modelo.RepositorioParticipante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDatos implements RepositorioParticipante {

    private Connection conn;

    public BaseDeDatos() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/participantes";
        String user = "root";
        String password = "";
        this.conn = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void guardar(Participante participante) {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO participantes(nombre, telefono, region) VALUES (?, ?, ?)")) {
            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el participante", e);
        }
    }
}
