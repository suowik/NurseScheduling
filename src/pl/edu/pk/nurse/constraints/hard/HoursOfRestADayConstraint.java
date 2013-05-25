package pl.edu.pk.nurse.constraints.hard;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;

import java.util.List;

/**
 * User: msendyka
 * Date: 25.05.13
 * Time: 10:27
 * •	During any period of 24 consecutive hours, at least 11 hours of rest is required.
 */
public class HoursOfRestADayConstraint extends HardConstraint {
    @Override
    public Fitness measure(Schedule schedule) {
        int violated = 0;

        for (Nurse nurse : schedule.toEntity()) {
            List<Shift> allShifts = nurse.getAllShifts();
            for (int i = 1; i < allShifts.size(); i++) {
                Shift today = allShifts.get(i - 1);
                Shift tommorow = allShifts.get(i);
                if (Shift.restBetween(today, tommorow) < 11) {
                    violated++;
                }
            }
        }
        return new Fitness(violated);
    }
}
