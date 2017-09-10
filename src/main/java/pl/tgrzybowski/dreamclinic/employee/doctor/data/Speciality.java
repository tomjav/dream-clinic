package pl.tgrzybowski.dreamclinic.employee.doctor.data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tomek on 10.09.17.
 */
@Entity
public class Speciality {
    @Id
    private Long id;
    private String name;
}
