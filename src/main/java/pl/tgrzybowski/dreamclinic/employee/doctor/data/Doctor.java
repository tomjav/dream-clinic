package pl.tgrzybowski.dreamclinic.employee.doctor.data;

import org.springframework.beans.factory.annotation.Autowired;
import pl.tgrzybowski.dreamclinic.employee.availability.data.AvailabilityDay;
import pl.tgrzybowski.dreamclinic.shared.PersonalData;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    private Long id;
    @Embedded
    private PersonalData personalData;
    @ManyToOne
    private Speciality speciality;
}
