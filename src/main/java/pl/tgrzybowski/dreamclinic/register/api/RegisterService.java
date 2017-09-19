package pl.tgrzybowski.dreamclinic.register.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.employee.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.employee.doctor.services.DoctorRepository;
import pl.tgrzybowski.dreamclinic.patient.Patient;
import pl.tgrzybowski.dreamclinic.patient.PatientRepository;
import pl.tgrzybowski.dreamclinic.register.entity.Account;
import pl.tgrzybowski.dreamclinic.shared.PersonalData;

import javax.transaction.Transactional;


@Service
public class RegisterService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void registerPatient(RegisterPatient dto) {
        Role role = roleRepository.findByRole("PATIENT");
        Account account = getAccount(dto);
        account.setRole(role);
        Patient patient = new Patient();
        PersonalData personalData = new PersonalData(dto.getName(), dto.getSurname(), null, null);
        patient.setPersonalData(personalData);
        patient.setAccount(account);
        patientRepository.save(patient);
    }

    @Transactional
    public void registerDoctor(RegisterDoctor dto) {
        Account account = getAccount(dto);
        Role role = new Role();
//    role.setId(1L);
        role.setRole("ROLE_DOCTOR");
//    account.setId(1L);
        account.setRole(role);
        Doctor doctor = new Doctor();
//    doctor.setId(1L);
        doctor.setAccount(account);
        doctorRepository.save(doctor);
    }

    private Account getAccount(RegisterDTO account) {
        String password = account.getPassword();
        String encodePassword = encodePassword(password);
        Account acc = new Account();
        acc.setPassword(encodePassword);
        acc.setUsername(account.getUsername());
        return acc;
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }


}
