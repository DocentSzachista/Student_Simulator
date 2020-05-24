/**
 * Klasa abstrakcyjna przechowujaca deklaracje pol  i prototyp metody porownujacy wybrana
 * statystyke ze statystyka Studenta
 */
public abstract class EventBase
{
    protected String description;
    protected int requiredStatistic;
    protected StatisticType typeOfStatistic;
    public abstract void evaluateStudent(Student student);
}
