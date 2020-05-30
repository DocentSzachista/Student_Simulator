package simulation;

import simulation.event.EventsDatabase;
import simulation.plan.Day;
import simulation.plan.Plan;
import simulation.plan.RandomPlanGenerator;
import simulation.student.Student;
import simulation.student.StudentStatGenerator;
import simulation.subject.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * <p>Program mający za zadanie utworzyć studenta i poddać go próbie przetrwania pierwszego semestru
 * na uczelni.</p>
 *
 * @author Damian Raczkowski
 * @author Jan Malek
 * @version 2.0
 * @since 30-05-2020
 * Klasa Application odpowiada za wygenerowanie studenta, planu, oraz wydarzeń dla przedmiotów oraz weekendów
 */
public class Application
{
    /**
    * Główna metoda programu
    */
    public static void main(String[] args)
    {
        List<Subject> availableSubjects = new ArrayList<>();

        EventsDatabase database = new EventsDatabase();

        availableSubjects.add(new Subject("Matematyka", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Filozofia", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Programowanie", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Miernictwo", database.getSchoolEvents()));
        availableSubjects.add(new Subject("Fizyka", database.getSchoolEvents()));

        RandomPlanGenerator randomPlanGenerator = new RandomPlanGenerator(availableSubjects);
        StudentStatGenerator statGenerator = new StudentStatGenerator();
        Simulation simulation = new Simulation(database.getWeekendEvents(), new Student(statGenerator.generate(), randomPlanGenerator.generate()));

        simulation.run(10);
    }
}



