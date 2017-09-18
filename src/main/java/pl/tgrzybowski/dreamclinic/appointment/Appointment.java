package pl.tgrzybowski.dreamclinic.appointment;

import pl.tgrzybowski.dreamclinic.Patient;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Doctor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    private Long id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    private String reason;

    private Date date;
}
