package pl.edu.pk.nurse.constraints.soft;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;
import pl.edu.pk.nurse.data.util.Vacancy;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 01.06.13
 * Time: 14:30
 */
public class NightShiftsSeries3048Constraint extends SoftConstraint {

    @Override
    public Fitness measure(Schedule schedule) {
        int penalty = 0;

        for (Nurse nurse : schedule.toEntity()) {
            if (nurse.getVacancy().equals(Vacancy.FULL) || nurse.getVacancy().equals(Vacancy.PART_32)) {
                int maxSeriesLength = 0;
                int seriesLength = 0;
                for (Shift shift : nurse.getAllShifts()) {
                    if (shift.equals(Shift.NIGHT)) {
                        seriesLength++;
                    } else {
                        maxSeriesLength = Math.max(maxSeriesLength, seriesLength);
                        seriesLength = 0;
                    }
                }
                int factor = 0;
                if (maxSeriesLength < 2) {
                    factor = 2 - maxSeriesLength;
                } else if (maxSeriesLength > 3) {
                    factor = maxSeriesLength - 3;
                }
                penalty += 1000 * factor;
            }
        }
        return new Fitness(penalty);
    }
}
