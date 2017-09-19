package pl.tgrzybowski.dreamclinic.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tgrzybowski.dreamclinic.register.api.RegisterDoctor;
import pl.tgrzybowski.dreamclinic.register.api.RegisterPatient;
import pl.tgrzybowski.dreamclinic.register.api.RegisterService;

@RestController
@RequestMapping(value = "/register")
public class RegistrationController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/doctor", method = RequestMethod.POST)
    public void registerDoctor(@RequestBody RegisterDoctor registerDTO) {
        registerService.registerDoctor(registerDTO);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public void registerPatient(@RequestBody RegisterPatient registerDTO) {
        registerService.registerPatient(registerDTO);
    }

}
