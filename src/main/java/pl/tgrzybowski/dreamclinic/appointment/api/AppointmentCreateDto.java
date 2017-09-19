package pl.tgrzybowski.dreamclinic.appointment.api;

import lombok.Data;

@Data
public class AppointmentCreateDto {
    private Long doctorId;
    private Long patientId;
    private Long dayId;
    private Long hourFrom;
    private Long hourTo;
}
