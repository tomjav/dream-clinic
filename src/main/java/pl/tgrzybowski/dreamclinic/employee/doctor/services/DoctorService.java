package pl.tgrzybowski.dreamclinic.employee.doctor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Doctor;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getDoctors(){

//        return doctorRepository.findAll();
        return null;
    }

    public List<Doctor> getDoctorWithSpeciality(Long specialityId) {
        return doctorRepository.findAllBySpeciality(specialityId);
    }

}
