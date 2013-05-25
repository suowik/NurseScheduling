package pl.edu.pk.nurse.algorithm;

import pl.edu.pk.nurse.data.Schedule;

import java.util.Arrays;
import java.util.Random;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 12:46
 */
public class Mutate implements Operation {

    private static final Random RANDOM = new Random();

    public Schedule apply(Schedule schedule) {
        int[] chromosome = schedule.getChromosome();
        double probability = 0.02;
        int[] result = Arrays.copyOf(chromosome,chromosome.length);
        for(int i = 0; i < chromosome.length; i++){
            if(i % 8 != 0 && RANDOM.nextDouble() < probability){
                result[i] = (int) (Math.random()*5);
            }
        }
        return new Schedule(result);
    }
}
