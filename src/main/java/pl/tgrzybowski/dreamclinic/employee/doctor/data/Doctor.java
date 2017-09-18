package pl.tgrzybowski.dreamclinic.employee.doctor.data;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.employee.doctor.api.DoctorDto;
import pl.tgrzybowski.dreamclinic.shared.PersonalData;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Doctor {
    @Id
    private Long id;
    @Embedded
    private PersonalData personalData;
    @ManyToOne
    private Speciality speciality;

    private String img;

    public DoctorDto toDto() {
        return new DoctorDto(id, personalData.getName(), personalData.getSurname(), speciality.getId(), speciality.getName(), img);
    }
}
