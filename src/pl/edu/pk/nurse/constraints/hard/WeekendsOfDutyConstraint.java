package pl.edu.pk.nurse.constraints.hard;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Week;
import pl.edu.pk.nurse.data.util.Weekday;

/**
 * User: msendyka
 * Date: 25.05.13
 * Time: 10:08
 * •	A nurse must receive at least 2 weekends off duty per 5 week period. A weekend off duty lasts 60 hours including Saturday 00:00 to Monday 04:00.
 */
public class WeekendsOfDutyConstraint extends HardConstraint {
    @Override
    public Fitness measure(Schedule schedule) {
        int violated = 0;

        for (Nurse nurse : schedule.toEntity()) {
            int weekendsOfDuty = 0;
            for (int i = 0; i < 6; i++) {
                Week week = nurse.getWeek(i);

                Shift friday = week.getShiftForDay(Weekday.FRIDAY);
                Shift saturday = week.getShiftForDay(Weekday.SATURDAY);
                Shift sunday = week.getShiftForDay(Weekday.SUNDAY);
                if (friday != Shift.NIGHT &&
                        saturday == Shift.NO_SHIFT &&
                        sunday == Shift.NO_SHIFT) {
                    weekendsOfDuty++;
                }
            }
            if (weekendsOfDuty < 2) {
                violated++;
            }
        }
        return new Fitness(violated);
    }
}
