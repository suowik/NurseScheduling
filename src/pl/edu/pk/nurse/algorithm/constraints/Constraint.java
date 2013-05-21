package pl.edu.pk.nurse.algorithm.constraints;

import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Weight;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 11:28
 */
public interface Constraint {
    Weight measure(Schedule schedule);
}
