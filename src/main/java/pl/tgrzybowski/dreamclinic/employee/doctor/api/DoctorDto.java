package pl.tgrzybowski.dreamclinic.employee.doctor.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String name;
    private String surname;
    private Long specialityId;
    private String speciality;
    private String img;
}
