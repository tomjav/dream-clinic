package pl.tgrzybowski.dreamclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.appointment.api.AppointmentCreateDto;
import pl.tgrzybowski.dreamclinic.common.DateUtil;
import pl.tgrzybowski.dreamclinic.availability.api.FilterDto;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.doctor.services.DoctorRepository;
import pl.tgrzybowski.dreamclinic.patient.Patient;
import pl.tgrzybowski.dreamclinic.patient.PatientRepository;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void createAppointment(AppointmentCreateDto dto) {
        Patient patient = patientRepository.findOne(dto.getPatientId());
        Doctor doctor = doctorRepository.findOne(dto.getDoctorId());

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDate(dto.getDate());
        appointment.setHourFrom(dto.getHourFrom());
        appointment.setHourTo(dto.getHourTo());
        appointment.setReason(dto.getReason());

        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentDoctorInTime(Long doctorId, FilterDto filter) {

        Date dateFrom = DateUtil.parseDate(filter.getDateFrom());
        Date dateTo = DateUtil.parseDate(filter.getDateTo());

        List<Appointment> appointments = appointmentRepository.getAppointmentDoctor(doctorId, dateFrom,
                dateTo, filter.getFrom(), filter.getTo());
        return appointments;
    }
}
