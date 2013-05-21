package pl.edu.pk.nurse.algorithm;

import pl.edu.pk.nurse.constraints.Constraint;
import pl.edu.pk.nurse.constraints.hard.ExampleConstraint;
import pl.edu.pk.nurse.data.Schedule;
import pl.edu.pk.nurse.data.util.Fitness;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 16:37
 */
public class FitnessCalculator {
    public static Fitness measure(Schedule schedule){
        Constraint constraint = new ExampleConstraint();
        Fitness partialFitness = constraint.measure(schedule);
        return partialFitness;
    }
}
