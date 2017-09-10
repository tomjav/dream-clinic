package pl.tgrzybowski.dreamclinic.employee.availability.data;

import pl.tgrzybowski.dreamclinic.employee.doctor.data.Doctor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class AvailabilityDay {

    @Id
    private Long id;

    private Date date;

    @OneToMany(mappedBy = "availabilityDayId")
    private List<AvailabilityHours> availabilityHours;

    @ManyToOne
    private Doctor doctor;
}
