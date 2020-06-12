package simulation;

import simulation.event.Event;
import simulation.plan.Day;
import simulation.plan.Plan;
import simulation.student.Notes;
import simulation.student.Student;
import simulation.subject.Subject;

import java.util.List;
import java.util.Random;

/**
 * Klasa Simulation odpowiada za przeprowadzenie symulacji (wybranie odpowiednich wydarzeń do dni, oraz sprawdzenie czy symulacja została zakończona sukcesem)
 */
public class Simulation
{
    private final List<Event> weekendEvents;
    private final Student student;
    private final Random rand;

    /**
    * Konstruktor klasy
    * @param weekendEvents Lista zawierająca wszystkie możliwe wydarzenia jakie mogą odbyć się w weekend
    * @param student Student, dla którego symulacja będzie przeprowadzana
    */
    public Simulation(List<Event> weekendEvents, Student student)
    {
        this.weekendEvents = weekendEvents;
        this.student = student;

        rand = new Random();
    }

    /**
     * Metoda która przeprowadza symulację
     * @param weeks Ilość tygodni sumulacji
     */
    public void run(int weeks)
    {
        System.out.println("Statystyki studenta to:\n" + student);
        for (int week = 1; week <= weeks; week++)
        {
            for(Day currentDay : Day.values())
            {
                applyEventsAccordingToDay(currentDay, week);
            }
        }
        semesterSummary();
    }

    /**
     * Metoda sprawdzająca, czy symulacja zakończyła się powodzeniem, oraz wyświetlająca końcowe wyniki studenta
     */
    private void semesterSummary() {
        Notes notes = student.getNotes();
        List<Subject> subjects = notes.getSubjects();
        System.out.println("\nKoniec semestru. Wyniki studenta to:\n");

        float average = summaryLoop(notes, subjects);
        if (average < 3f)
            System.out.println("\nStudent nie zdał ze średnią: " + average + " powodzenia na poprawce!");
        else
            System.out.println("\nStudent zdał ze średnią: " + average + " gratulacje!");
    }

    /**
     * Pętla zliczająca oceny
     *
     * @param notes    dziennik studenta
     * @param subjects przedmioty na które uczęszczał
     * @return średnia ocen
     */
    private float summaryLoop(Notes notes, List<Subject> subjects) {
        float allMarks = 0;
        int marksAmount = 0;
        for (Subject subject : subjects) {
            float score = notes.getAverageFor(subject);
            allMarks += score;
            marksAmount++;
            System.out.println("Średnia z: " + subject + " to: " + score);
        }
        return Math.round(allMarks / marksAmount * 100f) / 100f;
    }

    /**
     * Metoda, która przeporwadza wydarzenie dla każdego dnia
     * @param currentDay Dla jakiego dnia ma być przeprowadzone wydarzenie
     * @param week Numer tygodnia w którym ten dzień się znajduje
     */
    private void applyEventsAccordingToDay(Day currentDay, int week) {
        System.out.println("Dziś jest " + currentDay.name() + " tydzień " + week);

        if (currentDay == Day.SATURDAY || currentDay == Day.SUNDAY) {
            System.out.println("Weekend! Brak zajęć");
            Event event = getRandomWeekendEvent();
            event.apply(student, null);
        } else {
            Plan plan = student.getPlan();
            List<Subject> currentDaySubjects = plan.getSubjectsFor(currentDay);
            applyEverySubjectEvents(currentDaySubjects);
        }
        student.removeExpiredStatisticChanges();
        System.out.println();
    }

    /**
     * Metoda do przeprowadzania wydarzenia dla przedmiotu
     *
     * @param currentDaySubjects Lista przedmiotów, dla których mają zostać przeprowadzone wydarzenia
     */
    private void applyEverySubjectEvents(List<Subject> currentDaySubjects) {
        for (Subject subject : currentDaySubjects) {
            Notes notes = student.getNotes();
            System.out.println("Dzisiejsze zajęcia to: " + subject);
            System.out.println("Obecna średnia z " + subject + " to: " + notes.getAverageFor(subject));
            Event schoolEvent = subject.randomEvent();
            schoolEvent.apply(student, subject);
        }
    }

    /**
     * Metoda do losowania wydarzenia, które ma być przeprowadzone w weekend
     * @return Wylosowane wydarzenie
     */
    private Event getRandomWeekendEvent()
    {
        int index = rand.nextInt(weekendEvents.size() - 1) + 1;
        Event returnEvent = weekendEvents.get(index);
        weekendEvents.set(index, weekendEvents.get(0));
        weekendEvents.set(0, returnEvent);

        return returnEvent;
    }
}
