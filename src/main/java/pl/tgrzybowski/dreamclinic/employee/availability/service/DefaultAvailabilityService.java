package pl.tgrzybowski.dreamclinic.employee.availability.service;

import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.employee.availability.api.HourStatus;
import pl.tgrzybowski.dreamclinic.employee.availability.api.WorkingHour;

import java.util.LinkedList;
import java.util.List;

@Service
public class DefaultAvailabilityService {

    public List<WorkingHour> getDefaultWorkingHours() {
        List<WorkingHour> output = new LinkedList<>();
        HourStatus status;
        for (int i = 7; i < 20; i++) {
            if (i == 7) {
                status = HourStatus.HOUR_OFF;
            } else {
                if (i < 17) {
                    status = HourStatus.FREE;
                } else {
                    status = HourStatus.HOUR_OFF;
                }
            }
            output.add(new WorkingHour(i, i + 1, status));
        }
        return output;
    }
}
