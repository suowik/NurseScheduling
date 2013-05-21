package pl.edu.pk.nurse.algorithm;

import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 16:37
 */
public class FitnessCalculator {
    public static Fitness measure(Schedule schedule){
        return new Fitness(10);
    }
}
