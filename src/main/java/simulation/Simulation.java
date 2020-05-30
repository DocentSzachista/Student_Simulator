package simulation;

import simulation.event.Event;
import simulation.plan.Day;
import simulation.plan.Plan;
import simulation.student.Notes;
import simulation.student.Student;
import simulation.subject.Subject;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Simulation {
    private final List<Event> weekendEvents;
    private final Student student;
    private final Random rand;

    public Simulation(List<Event> weekendEvents, Student student)
    {
        this.weekendEvents = weekendEvents;
        this.student = student;

        rand = new Random();
    }

    public void run(int weeks)
    {
        System.out.println("Statystyki studenta to:\n" + student);
        for (int week = 1; week <= weeks; week++)
        {
            for(Day currentDay : Day.values())
            {
                applyEventsAccordingToDay(currentDay);
            }
        }
    }

    private void applyEventsAccordingToDay(Day currentDay) {
        System.out.println("Dziś jest " + currentDay.name());

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

    private void applyEverySubjectEvents(List<Subject> currentDaySubjects) {
        for (Subject subject : currentDaySubjects) {
            Notes notes = student.getNotes();
            System.out.println("Dzisiejsze zajęcia to: " + subject);
            System.out.println("Obecna średnia z " + subject + " to: " + notes.getAverageFor(subject));
            Event schoolEvent = subject.randomEvent();
            schoolEvent.apply(student, subject);
        }
    }

    private Event getRandomWeekendEvent()
    {
        int index = rand.nextInt(weekendEvents.size() - 1) + 1;
        Event returnEvent = weekendEvents.get(index);
        weekendEvents.set(index, weekendEvents.get(0));
        weekendEvents.set(0, returnEvent);

        return returnEvent;
    }
}
