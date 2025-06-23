package org.example.ejercicio2.Persistencia;

import org.example.ejercicio2.Modelo.Empleado;
import org.example.ejercicio2.Modelo.RepositorioEmpleados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ArchivoEmpleados implements RepositorioEmpleados {
    private String path;

    public ArchivoEmpleados(String path) {
        this.path = path;
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(",");
                empleados.add(new Empleado(partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo archivo de empleados", e);
        }
        return empleados;
    }
}
