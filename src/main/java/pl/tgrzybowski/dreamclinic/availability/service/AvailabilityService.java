package pl.tgrzybowski.dreamclinic.availability.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.appointment.Appointment;
import pl.tgrzybowski.dreamclinic.appointment.AppointmentRepository;
import pl.tgrzybowski.dreamclinic.availability.api.*;
import pl.tgrzybowski.dreamclinic.availability.data.Availability;
import pl.tgrzybowski.dreamclinic.availability.data.AvailabilityRepository;
import pl.tgrzybowski.dreamclinic.common.DateUtil;
import pl.tgrzybowski.dreamclinic.doctor.api.DoctorDto;
import pl.tgrzybowski.dreamclinic.doctor.data.Doctor;
import pl.tgrzybowski.dreamclinic.doctor.services.DoctorRepository;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private DefaultAvailabilityService defaultAvailabilityService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    public List<ProposeAppointmentDto> getAvailabilityDoctorInTime(Long specialityId, FilterDto filter) {

        Date dateFrom = DateUtil.parseDate(filter.getDateFrom());
        Date dateTo = DateUtil.parseDate(filter.getDateTo());

        List<Doctor> doctor = doctorRepository.findAllBySpeciality(specialityId);

        List<ProposeAppointmentDto> output = new ArrayList<>();

        doctor.forEach(e -> output.addAll(availabilityRepository.
                findAllByDoctorAndDateBetweenAndHourFromGreaterThanEqualAndHourToLessThanEqual
                        (e, dateFrom, dateTo, filter.getFrom(), filter.getTo())
                .stream().map(r -> {
                    DoctorDto doctorDto = r.getDoctor().toDto();
                    return new ProposeAppointmentDto(doctorDto, r.getDate(), r.getHourFrom(), r.getHourTo(), r.getId());

                }).collect(Collectors.toList())
        ));

        return output;
    }


    public List<WorkingHour> getWorkingHoursList(Long doctorId, Date date) {
        Doctor doctor = doctorRepository.findOne(doctorId);
        List<Availability> workingHours = availabilityRepository.findAllByDoctorEqualsAndDateEquals(doctor, date);

        List<Appointment> doctorAppointments = appointmentRepository.findAllByDoctorEqualsAndDateEquals(doctor, date);

        List<WorkingHour> defaultWorkingHours = defaultAvailabilityService.getDefaultWorkingHours();

        List<WorkingHour> urgentHours =
                workingHours.stream().map(e -> new WorkingHour(e.getHourFrom(), e.getHourTo(), HourStatus.FREE_TIME)).collect(Collectors.toList());

        List<WorkingHour> appointmentHours =
                doctorAppointments.stream().map(e -> new WorkingHour(e.getHourFrom(), e.getHourTo(), HourStatus.APPOINTMENT)).collect(Collectors.toList());

        List<WorkingHour> mergedHours =
                defaultWorkingHours.stream().filter(e -> urgentHours.stream().noneMatch(p -> e.getFrom().equals(p.getFrom()))).collect(Collectors.toList());

        mergedHours = mergedHours.stream()
                .filter(e -> appointmentHours.stream()
                        .noneMatch(p -> e.getFrom().equals(p.getFrom())))
                .collect(Collectors.toList());

        mergedHours.addAll(urgentHours);
        mergedHours.addAll(appointmentHours);
        mergedHours.sort((e, p) -> {
            if (e.getFrom().equals(p.getFrom())) return 0;
            else if (e.getFrom() > p.getFrom()) return 1;
            return -1;
        });
        return mergedHours;
    }

    public List<WorkingDayDto> getDoctorAvailabilityCalendar(Long doctorId, Integer year, Integer month) {
        LocalDate calendar = LocalDate.of(year, month, 1);
        boolean leapYear = calendar.isLeapYear();
        int daysInMonthAmount = calendar.getMonth().length(leapYear);

        int firstDayOfWeekInMonthId = calendar.getDayOfWeek().getValue() - 1;
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();


        int today = LocalDate.now().getDayOfMonth();

        int dayIdCounter = 0;
        boolean firstWeek = true;
        LinkedList<WorkingDayDto> availabilityDays = new LinkedList<>();
        boolean currentMonth = true;
        for (int i = 0; i < 6; i++) {

            int offset = firstWeek ? firstDayOfWeekInMonthId : 0;

            for (int j = offset; j < 7; j++) {

                WorkingDayDto workingDayDto = new WorkingDayDto();
                workingDayDto.setDoctorAvailable(true);

                if (dayIdCounter > daysInMonthAmount) {
                    dayIdCounter = 1;
                    currentMonth = false;
                }

                int dayNumber = ++dayIdCounter % (daysInMonthAmount + 1);
                dayNumber = dayNumber == 0 ? 1 : dayNumber;

                workingDayDto.setDayNumber(dayNumber);
                workingDayDto.setCurrentMonth(currentMonth);

                int dayOfweekArrayIndex = (firstDayOfWeekInMonthId + dayIdCounter - 1) % (dayOfWeeks.length);
                workingDayDto.setDayOfWeek(dayOfweekArrayIndex);
                availabilityDays.add(workingDayDto);
            }
            firstWeek = false;
        }

        int expectedDayAmout = 6 * 7;

        int missedDayAmount = expectedDayAmout - availabilityDays.size();
        LinkedList<WorkingDayDto> missedDays = new LinkedList<>();
        for (int i = 0; i < missedDayAmount; i++) {
            WorkingDayDto day = new WorkingDayDto();
            day.setCurrentMonth(false);
            day.setDayOfWeek(i);
            day.setDoctorAvailable(false);
            missedDays.add(day);
        }

        availabilityDays.addAll(0, missedDays);

        return availabilityDays;
    }

    @Transactional
    public void addAvailabilityHour(Long doctorId, Date date, Integer hourFrom, Integer hourTo) {
        Doctor doctor = doctorRepository.findOne(doctorId);
        Availability availability = new Availability();
        availability.setDate(DateUtil.format(date));
        availability.setDoctor(doctor);
        availability.setHourFrom(hourFrom);
        availability.setHourTo(hourTo);
        availabilityRepository.save(availability);
    }
}
