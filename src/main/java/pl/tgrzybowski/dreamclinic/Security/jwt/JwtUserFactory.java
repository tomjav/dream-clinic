package pl.tgrzybowski.dreamclinic.Security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import pl.tgrzybowski.dreamclinic.register.entity.Account;
import pl.tgrzybowski.dreamclinic.register.api.Role;

import java.util.Arrays;
import java.util.List;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(Account user, String name, String lastname, Long patientId, Long doctorId) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                name,
                lastname,
                mapToGrantedAuthorities(user.getRole()),
                doctorId, patientId
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role role) {
        return Arrays.asList(new SimpleGrantedAuthority(role.getRole()));
    }
}
