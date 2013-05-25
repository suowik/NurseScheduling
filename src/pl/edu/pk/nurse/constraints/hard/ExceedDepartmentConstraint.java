package pl.edu.pk.nurse.constraints.hard;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;

import java.util.List;

/**
 * User: msendyka
 * Date: 25.05.13
 * Time: 11:05
 * Within a scheduling period a nurse is allowed
 * to exceed the number of hours for  which they are available for their department by at most 4 hours.
 */
public class ExceedDepartmentConstraint extends HardConstraint {
    @Override
    public Fitness measure(Schedule schedule) {
        int violated = 0;

        for (Nurse nurse : schedule.toEntity()) {
            List<Shift> allShifts = nurse.getAllShifts();
            int scheduledHours = 0;
            for (int i = 0; i < allShifts.size(); i++) {
                Shift today = allShifts.get(i);
                if (today != Shift.NO_SHIFT) {
                    if (today == Shift.NIGHT) {
                        scheduledHours += 8;
                    } else {
                        scheduledHours += 9;
                    }
                }
            }
            if (scheduledHours > nurse.getVacancy().getValue() + 4) {
                violated++;
            }
        }
        return new Fitness(violated);
    }
}
