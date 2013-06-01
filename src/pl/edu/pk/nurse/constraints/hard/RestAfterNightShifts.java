package pl.edu.pk.nurse.constraints.hard;

import pl.edu.pk.nurse.Configuration;
import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Week;
import pl.edu.pk.nurse.data.util.Weekday;

/**
 * User: msendyka
 * Date: 24.05.13
 * Time: 21:05
 * •	Following a series of at least 2 consecutive night shifts a 42 hours rest is required.
 */
public class RestAfterNightShifts extends HardConstraint {
    public static final int MINIMUM_REST = 42;

    @Override
    public Fitness measure(Schedule schedule) {
        int violated = 0;
        int rest = 0;
        for (Nurse nurse : schedule.toEntity()) {
            int consecutiveShifts = 0;
            for (int i = 0; i < 5; i++) {
                Week week = nurse.getWeek(i);
                for (Weekday weekday : Weekday.values()) {
                    Shift shiftForDay = week.getShiftForDay(weekday);
                    rest += Shift.restBetween(week.getShiftForDay(Weekday.forIndex(weekday.index())), shiftForDay);
                    if (shiftForDay == Shift.NIGHT) {
                        consecutiveShifts++;
                    } else {
                        if (consecutiveShifts >= 2 && rest < MINIMUM_REST) {
                            violated++;
                        }
                        consecutiveShifts = 0;
                    }
                    if (shiftForDay != Shift.NO_SHIFT) {
                        rest = 0;
                    }
                }
            }
        }
        return new Fitness(violated * Configuration.HARD_CONSTRAINT_WEIGHT);
    }

}
