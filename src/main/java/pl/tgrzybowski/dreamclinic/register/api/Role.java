package pl.tgrzybowski.dreamclinic.register.api;

import lombok.Data;

import javax.persistence.*;

@Table(name = "ROLE")
@Entity
@Data
public class Role {

    @Id
    @Column(name = "ID_ROLE", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ROLE")
    private String role;
}
