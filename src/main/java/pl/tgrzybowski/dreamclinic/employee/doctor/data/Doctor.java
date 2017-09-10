package pl.tgrzybowski.dreamclinic.employee.doctor.data;

import pl.tgrzybowski.dreamclinic.shared.PersonalData;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Doctor {
    @Id
    private Long id;
    @Embedded
    private PersonalData personalData;
    @ManyToOne
    private Speciality speciality;
}
