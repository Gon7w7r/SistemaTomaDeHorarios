package com.sistema.sistematomahorarios.services;

import com.sistema.sistematomahorarios.dto.InscripcionDetalleDTO;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PdfHorarioService pdfHorarioService;

    public void enviarCorreoInscripcion(String emailDestino, String nombreAlumno,
                                        List<InscripcionDetalleDTO> inscripciones) {
        try {
            byte[] pdfBytes = pdfHorarioService.generarPdf(nombreAlumno, inscripciones);

            MimeMessage mensaje = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

            helper.setTo(emailDestino);
            helper.setSubject("Confirmación de inscripción de asignaturas — Nexus Materia");
            helper.setText(construirCuerpoHtml(nombreAlumno, inscripciones), true);
            helper.addAttachment(
                "horario_" + nombreAlumno.replace(" ", "_") + ".pdf",
                new ByteArrayDataSource(pdfBytes, "application/pdf")
            );

            mailSender.send(mensaje);

        } catch (Exception e) {
            System.err.println("Error al enviar correo: " + e.getMessage());
        }
    }

    private String construirCuerpoHtml(String nombre, List<InscripcionDetalleDTO> inscripciones) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div style='font-family: Arial, sans-serif; color: #333;'>")
          .append("<h2 style='color: #1A2E4A;'>Hola, ").append(nombre).append("</h2>")
          .append("<p>Se han inscrito exitosamente las siguientes asignaturas:</p>")
          .append("<table border='1' cellpadding='8' cellspacing='0' style='border-collapse: collapse; width: 100%;'>")
          .append("<thead>")
          .append("<tr style='background-color: #1A2E4A; color: white;'>")
          .append("<th>Asignatura</th><th>Sección</th><th>Día</th><th>Hora</th><th>Sala</th>")
          .append("</tr>")
          .append("</thead><tbody>");

        for (InscripcionDetalleDTO i : inscripciones) {
            sb.append("<tr>")
              .append("<td>").append(i.getNombreAsignatura()).append("</td>")
              .append("<td style='text-align:center;'>").append(i.getIdSeccion()).append("</td>")
              .append("<td>").append(i.getDiaSemana()).append("</td>")
              .append("<td>").append(i.getHoraInicio()).append(" - ").append(i.getHoraFin()).append("</td>")
              .append("<td>").append(i.getSala()).append("</td>")
              .append("</tr>");
        }

        sb.append("</tbody></table>")
          .append("<p style='margin-top: 20px;'>Adjunto encontrarás tu horario en formato PDF.</p>")
          .append("<p style='color: #888; font-size: 12px;'>Nexus Materia — Sistema de Toma de Horarios</p>")
          .append("</div>");

        return sb.toString();
    }
}