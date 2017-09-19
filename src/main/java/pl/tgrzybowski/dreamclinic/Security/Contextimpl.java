package pl.tgrzybowski.dreamclinic.Security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.tgrzybowski.dreamclinic.Security.jwt.JwtUser;

@Component
public class Contextimpl implements Context {


    public Long getUserId() {
        JwtUser principal = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getId();
    }

    public String getUsername() {
        JwtUser principal = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUsername();
    }

    public String getRole() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication().getAuthorities().stream().findFirst().get().getAuthority();
    }

}
