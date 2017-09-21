package pl.tgrzybowski.dreamclinic.appointment;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.patient.Patient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class Appointment {

    @Id
    private Long id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    private String reason;
    private String comment;
    private String symptom;

    private Date date;

    private Integer hourFrom;
    private Integer hourTo;


}
