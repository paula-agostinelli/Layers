package org.example.ejercicio1.UI;

import org.example.ejercicio1.Servicio.Servicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AgregarParticipante extends JFrame {

    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private Servicio servicio;

    public AgregarParticipante(Servicio servicio) {
            this.servicio = servicio;
        setupUIComponents();
}

private void setupUIComponents() {
    setTitle("Agregar Participante");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    nombre = new JTextField(10);
    telefono = new JTextField(10);
    region = new JTextField(10);
    region.setText("China");

    JPanel contentPane = new JPanel();
    contentPane.setLayout(new FlowLayout());

    contentPane.add(new JLabel("Nombre: "));
    contentPane.add(nombre);
    contentPane.add(new JLabel("Telefono: "));
    contentPane.add(telefono);
    contentPane.add(new JLabel("Region: "));
    contentPane.add(region);

    JButton botonCargar = new JButton("Cargar");
    botonCargar.addActionListener(this::onBotonCargar);
    contentPane.add(botonCargar);

    setContentPane(contentPane);
    pack();
    setVisible(true);
}

private void onBotonCargar(ActionEvent e) {
    try {
        servicio.registrarParticipante(
                nombre.getText(),
                telefono.getText(),
                region.getText()
        );
        JOptionPane.showMessageDialog(this, "Participante guardado con éxito");
        dispose();
    } catch (RuntimeException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }
}
}
