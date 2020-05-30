package simulation.subject;

import simulation.event.Event;

import java.util.List;
import java.util.Random;

/**
 * Klasa przechowywująca informacje o przedmiocie - jego nazwę oraz listę wydarzeń, jakie mogą się na nim zdarzyć
 */
public class Subject {

    private final String name;
    private final List<Event> possibleEvents;
    private final Random rand;

    /**
     * Konstruktor klasy
     * @param name Nazwa przedmiotu
     * @param possibleEvents Lista wydarzeń jakie mogą się na nim zdarzyć
     */
    public Subject(String name, List<Event> possibleEvents) {
        this.name = name;
        this.possibleEvents = possibleEvents;

        rand = new Random();
    }

    /**
     * Metoda zwracająca nazwę przedmiotu
     * @return Nazwa przedmiotu
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Metoda losująca wydarzenie, które ma się zdarzyć na tym przedmiocie
     * @return Wylosowane wydarzenie
     */
    public Event randomEvent() {
        int index = rand.nextInt(possibleEvents.size() - 1) + 1;
        Event returnEvent = possibleEvents.get(index);
        possibleEvents.set(index, possibleEvents.get(0));
        possibleEvents.set(0, returnEvent);

        return returnEvent;
    }

}
