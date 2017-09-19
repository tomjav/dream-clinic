package pl.tgrzybowski.dreamclinic.register.entity;

import lombok.Data;
import pl.tgrzybowski.dreamclinic.register.api.Role;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ACCOUNT", unique = true, nullable = false)
    private Long id;

    @Basic
    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Basic
    @Column(name = "PASSWORD", unique = false, nullable = false)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE")
    private Role role;

}
