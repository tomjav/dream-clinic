package pl.tgrzybowski.dreamclinic.doctor.data;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.doctor.api.DoctorDto;
import pl.tgrzybowski.dreamclinic.register.entity.Account;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Speciality speciality;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    private String img;

    private String title;

    public DoctorDto toDto() {
        return new DoctorDto(id, personalData.getName(), personalData.getSurname(),
                speciality.getId(), speciality.getName(), img, title);
    }
}
