package pl.tgrzybowski.dreamclinic.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.Security.jwt.JwtTokenUtil;
import pl.tgrzybowski.dreamclinic.Security.jwt.JwtUser;
import pl.tgrzybowski.dreamclinic.register.api.AccountRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class AccountController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDetails getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserDetails user = userDetailsService.loadUserByUsername(username);
        return user;
    }

}
