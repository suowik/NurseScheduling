package pl.edu.pk;

import pl.edu.pk.nurse.algorithm.Crossover;
import pl.edu.pk.nurse.algorithm.Mutate;
import pl.edu.pk.nurse.data.Schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int POPULATION_SIZE = 1500;
    private static final Crossover crossover = new Crossover();
    private static final Mutate mutate = new Mutate();
    private static final int OPTIMAL_SOLUTION = 0;
    private static int POPULATIONS = 0;

    public static void main(String[] args) {
        List<Schedule> initialPopulation = new ArrayList<Schedule>();
        long start = System.currentTimeMillis();
        for(int i  = 0; i < POPULATION_SIZE; i++){
            initialPopulation.add(new Schedule(16,12,3,1));
        }
        Schedule schedule = findScheduleWithBestFit(initialPopulation);
        System.out.println("TIME: "+(System.currentTimeMillis()-start));
        System.out.println("POPULATIONS:" +POPULATIONS);
        System.out.println(schedule);
    }

    private static Schedule findScheduleWithBestFit(List<Schedule> population) {
        calculateFitnessAndSort(population);
        if(isSatisfying(population)){
            return Collections.min(population);
        }
        List<Schedule> result = new ArrayList<Schedule>();
        for(int i = 0; i < population.size()-1;i++){
            Schedule offspring = crossover.apply(population.get(i), population.get(i + 1));
            offspring = mutate.apply(offspring);
            result.add(offspring);
            result.addAll(population);
        }
        result = result.subList(0,POPULATION_SIZE);
        return findScheduleWithBestFit(result);
    }

    private static boolean isSatisfying(List<Schedule> population) {
        int best = Collections.min(population).fitness().getValue();
        System.out.println("Current best result: "+ best);
        POPULATIONS++;
        return best <= OPTIMAL_SOLUTION;
    }

    private static void calculateFitnessAndSort(List<Schedule> population) {
        for (Schedule schedule : population) {
            schedule.fitness();
        }
        Collections.sort(population);
    }
}
