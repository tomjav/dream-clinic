package pl.tgrzybowski.dreamclinic.availability.service;

import org.springframework.stereotype.Service;
import pl.tgrzybowski.dreamclinic.availability.api.HourStatus;
import pl.tgrzybowski.dreamclinic.availability.api.WorkingHour;

import java.util.LinkedList;
import java.util.List;

@Service
public class DefaultAvailabilityService {

    public List<WorkingHour> getDefaultWorkingHours() {
        List<WorkingHour> output = new LinkedList<>();
        for (int i = 7; i < 20; i++) {
            output.add(new WorkingHour(i, i + 1, HourStatus.HOUR_OFF));
        }
        return output;
    }
}
