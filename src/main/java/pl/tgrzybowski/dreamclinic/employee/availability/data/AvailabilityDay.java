package pl.tgrzybowski.dreamclinic.employee.availability.data;

import lombok.Data;
import lombok.Setter;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Doctor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class AvailabilityDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date availabilityDay;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "availabilityDayId")
    private List<AvailabilityHours> availabilityHours;

    @ManyToOne
    private Doctor doctor;
}
