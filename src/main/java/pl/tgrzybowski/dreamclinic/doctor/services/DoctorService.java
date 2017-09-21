package pl.tgrzybowski.dreamclinic.doctor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor getDoctorInfo(Long id) {
        return doctorRepository.findOne(id);
    }

    public List<Doctor> getDoctorWithSpeciality(Long specialityId) {
        return doctorRepository.findAllBySpeciality(specialityId);
    }

}
