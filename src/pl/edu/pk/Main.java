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
    private static final int OPTIMAL_SOLUTION = 699;

    public static void main(String[] args) {
        List<Schedule> initialPopulation = new ArrayList<Schedule>();
        for(int i  = 0; i < POPULATION_SIZE; i++){
            initialPopulation.add(new Schedule(16,12,3,1));
        }
        Schedule schedule = execute(initialPopulation);
        System.out.println(schedule);
    }

    private static Schedule execute(List<Schedule> population) {
        calculateFitnessAndSort(population);
        if(isSatisfying(population)){
            return Collections.max(population);
        }
        List<Schedule> result = new ArrayList<Schedule>();
        for(int i = 0; i < population.size()-1;i++){
            Schedule offspring = crossover.apply(population.get(i), population.get(i + 1));
            offspring = mutate.apply(offspring);
            result.add(offspring);
            result.addAll(population);
        }
        result = result.subList(0,POPULATION_SIZE);
        return execute(result);
    }

    private static boolean isSatisfying(List<Schedule> population) {
        return Collections.max(population).fitness().getValue() > OPTIMAL_SOLUTION;
    }

    private static void calculateFitnessAndSort(List<Schedule> population) {
        for (Schedule schedule : population) {
            schedule.fitness();
        }
        Collections.sort(population);
    }
}
