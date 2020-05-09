/**Klasa EventAfterClasses sprawdza wydarzenie po zajęciach
 * Jeżeli student spełni wymagania to otrzyma tymczasowy boost do danej statystyki, w innym wypadku otrzyma ujemny.
 *
 */

public class EventAfterClasses extends EventBase
{
    /**
     * Stworzenie nowego wydarzenia po zajęciach
     * @param description opis wydarzenia
     * @param typeOfStatistic typ statystyki jaką wydarzenie sprawdza
     * @param requirements wymagania
     */
    public EventAfterClasses(String description, StatisticType typeOfStatistic, int requirements)
    {
        this.description=description;
        this.typeOfStatistic=typeOfStatistic;
        this.requirements=requirements;
    }

    /**
     *
     * @param student pobieranie informacji o statystyce studenta i porównywanie jej z ze statystyką wydarzenia
     * Stworzenie nowego bonusu do statystyk
     */
    @Override
    public void evaluateStudent(Student student)
    {
        StatisticChange zmiana;
        if (student.getStatistic(typeOfStatistic)>requirements)
        {
             zmiana = new StatisticChange(typeOfStatistic, 3, 2);

        }
        else
        {
             zmiana = new StatisticChange(typeOfStatistic, -3, 2);
        }
        student.addStatisticChange(zmiana);
    }
}
