package pl.tgrzybowski.dreamclinic.appointment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tgrzybowski.dreamclinic.appointment.api.AppointmentCreateDto;
import pl.tgrzybowski.dreamclinic.availability.api.FilterDto;

import java.util.List;

@RestController
@Slf4j
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointment")
    public void createAppointment(@RequestBody AppointmentCreateDto dto) {
        appointmentService.createAppointment(dto);
    }

    @GetMapping("/{doctorId}/appointment")
    public List<Appointment> createAppointment(@PathVariable Long doctorId, @ModelAttribute FilterDto dto) {
        return appointmentService.getAppointmentDoctorInTime(doctorId, dto);
    }
}
