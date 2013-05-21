package pl.edu.pk.nurse.constraints;

import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:28
 */
public interface Constraint {
    Fitness measure(Schedule schedule);
}
