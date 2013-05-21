package pl.edu.pk;

import pl.edu.pk.nurse.data.Schedule;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int POPULATION_SIZE = 1500;

    public static void main(String[] args) {
        List<Schedule> initialPopulation = new ArrayList<Schedule>();
        for(int i  = 0; i < POPULATION_SIZE; i++){
            initialPopulation.add(new Schedule(16,12,3,1));
        }
        //generowac 1500 schedule
        //1. sprawdzic dopasowanie
        //2. posortowac po dopasowaniu
        //3. przyjac 25% najlepszych
        //4. krzyzowanie
        //5. mutowanie
        //6. powrot do 1 jesli niezadowalajace
    }
}
