package pl.edu.pk.nurse.algorithm;

import pl.edu.pk.nurse.data.Schedule;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 12:45
 */
public interface Operation {
    public Schedule apply(Schedule first, Schedule second);
}
