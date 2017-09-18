package pl.tgrzybowski.dreamclinic.patient;

import pl.tgrzybowski.dreamclinic.shared.PersonalData;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    private Long id;

    @Embedded
    private PersonalData personalData;
}
