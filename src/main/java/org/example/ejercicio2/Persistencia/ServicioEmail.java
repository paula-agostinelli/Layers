package org.example.ejercicio2.Persistencia;

import org.example.ejercicio2.Modelo.EnvioMensaje;


public class ServicioEmail implements EnvioMensaje {
    private String from;

    public ServicioEmail(String from) {
        this.from = from;
    }

    @Override
    public void enviarEmail(String destinatario, String asunto, String mensaje) {
        // Create the email
        Email email = EmailBuilder.startingBlank()
                .from("Remitente Prueba", from)
                .to("Destinatario Prueba", destinatario)
                .withSubject(asunto)
                .withPlainText(mensaje)
                .buildEmail();


        Dotenv dotenv = Dotenv.load();
        // Obtener el usuario y la contraseña desde las variables de entorno
        String username = dotenv.get("MAILTRAP_USER");
        String password = dotenv.get("MAILTRAP_PASSWORD");

        // Create the mailer object with SMTP server settings
        Mailer mailer = MailerBuilder
                .withSMTPServer("sandbox.smtp.mailtrap.io", 587, username, password)
                .withTransportStrategy(TransportStrategy.SMTP)
                .buildMailer();

        // Send the email
        mailer.sendMail(email);

    }
    }

