package simulation;

import simulation.event.Event;
import simulation.plan.Day;
import simulation.plan.Plan;
import simulation.student.Notes;
import simulation.student.Student;
import simulation.subject.Subject;

import java.util.Iterator;
import java.util.List;

public class Simulation {
    private final List<Event> weekendEvents;
    private final Student student;

    public Simulation(List<Event> weekendEvents, Student student) {
        this.weekendEvents = weekendEvents;
        this.student = student;
    }

    public void run(Iterator<Day> daysToSimulate) {

        while (daysToSimulate.hasNext()) {
            Day currentDay = daysToSimulate.next();
            applyEventsAccordingToDay(currentDay);
        }
    }

    private void applyEventsAccordingToDay(Day currentDay) {
        System.out.println("Dziś jest " + currentDay.name());

        if (currentDay == Day.SATURDAY || currentDay == Day.SUNDAY) {
            System.out.println("Weekend! Brak zajęć");
            Event event = getRandomWeekendEvent();
            event.apply(student);
        } else {
            Plan plan = student.getPlan();
            List<Subject> currentDaySubjects = plan.getSubjectsFor(currentDay);
            applyEverySubjectEvents(currentDaySubjects);
        }
        student.removeExpiredStatisticChanges();
    }

    private void applyEverySubjectEvents(List<Subject> currentDaySubjects) {
        for (Subject subject : currentDaySubjects) {
            Notes notes = student.getNotes();
            System.out.println("Dzisiejsze zajęcia to: " + subject);
            System.out.println("Obecna średnia z " + subject + " to: " + notes.getAverageFor(subject));
            Event scientificEvent = subject.randomEvent();
            scientificEvent.apply(student);
        }
    }

    private Event getRandomWeekendEvent() {
        return null; // implement
    }
}
