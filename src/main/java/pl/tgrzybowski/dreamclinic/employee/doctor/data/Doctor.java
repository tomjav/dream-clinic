package pl.tgrzybowski.dreamclinic.employee.doctor.data;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.register.entity.Account;
import pl.tgrzybowski.dreamclinic.employee.doctor.api.DoctorDto;
import pl.tgrzybowski.dreamclinic.shared.PersonalData;

import javax.persistence.*;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private PersonalData personalData;

    @ManyToOne
    private Speciality speciality;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    private String img;

    public DoctorDto toDto() {
        return new DoctorDto(id, personalData.getName(), personalData.getSurname(), speciality.getId(), speciality.getName(), img);
    }
}
