package pl.tgrzybowski.dreamclinic.appointment.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentCreateDto {
    private Long doctorId;
    private String doctorName;
    private String doctorSurname;

    private Long patientId;
    private String patientName;
    private String patientSurname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer hourFrom;
    private Integer hourTo;

    private String reason;
    private String comment;
    private String symptom;

    private String speciality;
    private Long id;
}
