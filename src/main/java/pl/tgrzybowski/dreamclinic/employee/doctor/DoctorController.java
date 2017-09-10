package pl.tgrzybowski.dreamclinic.employee.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tgrzybowski.dreamclinic.employee.doctor.api.DoctorDto;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<DoctorDto> getDoctors(){

        return null;
    }
}
