package simulation.subject;

import simulation.event.Event;

import java.util.List;

/**
 * Klasa simulation.subject.Subject, przechowywujaca informacje o przedmiocie oraz liczbe ocen Studenta.
 * Sprawdza dla wylosowanego wydarzenia statystykę Studenta i po rozpatrzeniu dodaje
 * mu ocene.
 */
public class Subject {

    private final String name;
    private final List<Event> possibleEvents;

    public Subject(String name, List<Event> possibleEvents) {
        this.name = name;
        this.possibleEvents = possibleEvents;
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
        // implement
        return null;
    }

}
