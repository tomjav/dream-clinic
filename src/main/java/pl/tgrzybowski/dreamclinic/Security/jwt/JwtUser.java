package pl.tgrzybowski.dreamclinic.Security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final String name;
    private final String surname;
    private final Collection<? extends GrantedAuthority> roles;
    private final Long doctorId;
    private final Long patientId;

    public JwtUser(Long id,
                   String username,
                   String password,
                   String name,
                   String surname,
                   Collection<? extends GrantedAuthority> roles,
                   Long doctorId,
                   Long patientId
    ) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.roles = roles;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isEnabled() {
        return true; //TODO ??
    }
}
