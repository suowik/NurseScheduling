package pl.edu.pk.nurse.algorithm;

import pl.edu.pk.nurse.data.Schedule;

/**
 * User: suowik
 * Date: 21.05.13
 * Time: 12:46
 */
public class Crossover implements Operation {

    public Schedule apply(Schedule first, Schedule second) {
        int[] firstChromosome = first.getChromosome();
        int[] secondChromosome = second.getChromosome();
        int[] result = new int[first.getChromosome().length];
        int crossPoint = (int)(Math.random() * firstChromosome.length);
        merge(firstChromosome, result, 0, crossPoint);
        merge(secondChromosome, result, crossPoint, secondChromosome.length);
        return new Schedule(result);
    }

    private void merge(int[] firstChromosome, int[] result, int start, int end) {
        for( int i = start; i < end; i++){
            result[i] = firstChromosome[i];
        }
    }
}
