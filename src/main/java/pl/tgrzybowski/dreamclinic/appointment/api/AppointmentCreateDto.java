package pl.tgrzybowski.dreamclinic.appointment.api;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentCreateDto {
    private Long doctorId;
    private Long patientId;
    private Date date;
    private Integer hourFrom;
    private Integer hourTo;

    private String reason;
    private String comment;
    private String symptom;

    private Long id;
}
