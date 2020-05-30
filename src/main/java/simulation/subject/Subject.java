package simulation.subject;

import simulation.event.Event;

import java.util.List;
import java.util.Random;

/**
 * Klasa simulation.subject.Subject, przechowywujaca informacje o przedmiocie oraz liczbe ocen Studenta.
 * Sprawdza dla wylosowanego wydarzenia statystykę Studenta i po rozpatrzeniu dodaje
 * mu ocene.
 */
public class Subject {

    private final String name;
    private final List<Event> possibleEvents;
    private final Random rand;

    public Subject(String name, List<Event> possibleEvents) {
        this.name = name;
        this.possibleEvents = possibleEvents;

        rand = new Random();
    }

    /**
     * Uzyskanie informacji o sredniej ocen z kursu
     *
     * @return zwraca srednia jesli simulation.student uzyskal jakakolwiek ocenę
     */

    /**
     * Zwraca informacje czy simulation.student zdal przedmiot
     *
     * @return jezeli simulation.student uzyskal średnią równą lub większą od 3.0 to zwraca informację, ze zdal.
     */

    /**
     * Zwraca nazwe przedmiotu
     *
     * @return nazwa tego przedmiotu
     */
    @Override
    public String toString() {
        return name;
    }

    public Event randomEvent() {
        int index = rand.nextInt(possibleEvents.size() - 1) + 1;
        Event returnEvent = possibleEvents.get(index);
        possibleEvents.set(index, possibleEvents.get(0));
        possibleEvents.set(0, returnEvent);

        return returnEvent;
    }

}
