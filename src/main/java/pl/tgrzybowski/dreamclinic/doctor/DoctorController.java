package pl.tgrzybowski.dreamclinic.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.doctor.api.DoctorDto;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.doctor.services.DoctorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorDto> getDoctorsWithSpeciality(@RequestParam Long specialityId) {
        List<Doctor> doctorWithSpeciality = doctorService.getDoctorWithSpeciality(specialityId);
        return doctorWithSpeciality.stream().map(Doctor::toDto).collect(Collectors.toList());
    }
}
