package pl.tgrzybowski.dreamclinic.appointment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.appointment.api.AppointmentCreateDto;

@RestController
@Slf4j
public class AppointmentController {

    @PostMapping("/appointment")
    public String createAppointment(@RequestBody AppointmentCreateDto dto) {
        log.info("Tworzenie nowego spotkania!");
        return "Created!";
    }
}
