package pl.tgrzybowski.dreamclinic.patient;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.register.entity.Account;
import pl.tgrzybowski.dreamclinic.shared.PersonalData;

import javax.persistence.*;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Embedded
    private PersonalData personalData;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    private String email;
}
