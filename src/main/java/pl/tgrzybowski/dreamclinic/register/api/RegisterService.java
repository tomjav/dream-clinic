package pl.tgrzybowski.dreamclinic.register.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.doctor.data.Speciality;
import pl.tgrzybowski.dreamclinic.doctor.services.DoctorRepository;
import pl.tgrzybowski.dreamclinic.patient.Patient;
import pl.tgrzybowski.dreamclinic.patient.PatientRepository;
import pl.tgrzybowski.dreamclinic.register.entity.Account;
import pl.tgrzybowski.dreamclinic.shared.PersonalData;
import pl.tgrzybowski.dreamclinic.speciality.services.SpecialityRepository;

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

    @Autowired
    private SpecialityRepository specialityRepository;

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
        Role role = roleRepository.findByRole("DOCTOR");
        Account account = getAccount(dto);
        account.setRole(role);
        Doctor doctor = new Doctor();
        PersonalData personalData = new PersonalData(dto.getName(), dto.getSurname(), null, null);
        doctor.setPersonalData(personalData);
        doctor.setAccount(account);

        Speciality speciality = specialityRepository.findByNameEquals(dto.getSpecName());
        doctor.setSpeciality(speciality);

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
