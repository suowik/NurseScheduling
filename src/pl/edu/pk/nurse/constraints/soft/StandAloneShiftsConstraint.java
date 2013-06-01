package pl.edu.pk.nurse.constraints.soft;

import pl.edu.pk.nurse.data.Nurse;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;
import pl.edu.pk.nurse.data.util.Shift;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mhl
 * Date: 30.05.13
 * Time: 15:59
 */
public class StandAloneShiftsConstraint extends SoftConstraint {

    @Override
    public Fitness measure(Schedule schedule) {
        int penalty = 0;
        for (Nurse nurse : schedule.toEntity()) {
            List<Shift> nurseShifts = nurse.getAllShifts();
            for (int i = 1; i < nurseShifts.size() - 1; i++) {
                if (!nurseShifts.get(i).equals(Shift.NO_SHIFT) && nurseShifts.get(i - 1).equals(Shift.NO_SHIFT) && nurseShifts.get(i + 1).equals(Shift.NO_SHIFT)) {
                    penalty += 1000;
                }
            }
        }
        return new Fitness(penalty);
    }
}
