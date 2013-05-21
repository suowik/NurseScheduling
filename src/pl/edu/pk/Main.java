package pl.edu.pk;

import pl.edu.pk.nurse.data.Schedule;

public class Main {

    public static void main(String[] args) {
        Schedule schedule = new Schedule(16,12,3,1);
        System.out.println(schedule);
        //generowac 1500 schedule
        //1. sprawdzic dopasowanie
        //2. posortowac po dopasowaniu
        //3. przyjac 25% najlepszych
        //4. krzyzowanie
        //5. mutowanie
        //6. powrot do 1 jesli niezadowalajace
    }
}
