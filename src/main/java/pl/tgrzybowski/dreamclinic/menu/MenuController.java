package pl.tgrzybowski.dreamclinic.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.common.Para;
import pl.tgrzybowski.dreamclinic.register.api.AccountRepository;
import pl.tgrzybowski.dreamclinic.register.entity.Account;

import java.util.Arrays;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/menu")
    public List<Para> getMenu(@RequestParam String username) {
        Account acc = accountRepository.findByUsernameEquals(username);
        String role = acc.getRole().getRole();


        switch (role) {
            case "PATIENT": {
                return Arrays.asList(new Para("/specialities", "Umów wizytę"), new Para("/appointment", "Wizyty"));
            }
            case "DOCTOR": {
                return Arrays.asList(new Para("/availability", "Kalendarz"));
            }
            case "ADMIN": {
                return Arrays.asList(new Para("/admin/panel", "Panel Admina"));
            }
            default:
                return null;
        }
    }
}
