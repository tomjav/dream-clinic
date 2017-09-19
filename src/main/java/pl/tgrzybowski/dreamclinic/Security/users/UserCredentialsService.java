package pl.tgrzybowski.dreamclinic.Security.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.Security.jwt.JwtUserFactory;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.employee.doctor.services.DoctorRepository;
import pl.tgrzybowski.dreamclinic.patient.Patient;
import pl.tgrzybowski.dreamclinic.patient.PatientRepository;
import pl.tgrzybowski.dreamclinic.register.entity.Account;

/*
* Ten bean jest automatycznie wstrzykiwany do Spring OAuth poprzez interfejs
* */
@Service
public class UserCredentialsService implements UserDetailsService {

    @Autowired
    private UserCredentialsRepository userRepo;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = userRepo.findByUsername(username);

        switch (user.getRole().getRole()) {
            case "PATIENT": {
                Patient patient = patientRepository.findOneByAccountId(user.getId());
                return JwtUserFactory.create(user, patient.getPersonalData().getName(), patient.getPersonalData().getSurname(), patient.getId(), null);
            }
            case "DOCTOR": {
                Doctor doctor = doctorRepository.findOneByAccountId(user.getId());
                return JwtUserFactory.create(user, doctor.getPersonalData().getName(), doctor.getPersonalData().getSurname(), null, doctor.getId());
            }
            case "ADMIN": {
                return JwtUserFactory.create(user, null, null, null, null);
            }
        }
        throw new RuntimeException("Role not defined");
    }
}
