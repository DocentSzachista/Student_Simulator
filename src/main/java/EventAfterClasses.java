import java.util.Random;

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
     * @param requiredStatistic wymagana ilość statystyki
     */
    public EventAfterClasses(String description, StatisticType typeOfStatistic, int requiredStatistic)
    {
        this.description=description;
        this.typeOfStatistic=typeOfStatistic;
        this.requiredStatistic=requiredStatistic;
    }

    /**
     *
     * @param student pobieranie informacji o statystyce studenta i porównywanie jej z ze statystyką wydarzenia
     * Stworzenie nowego bonusu do statystyk
     */
    @Override
    public void evaluateStudent(Student student)
    {
        Random random= new Random();
        int boost= random.nextInt(3)+2;
        int days= random.nextInt(3)+1;
        StatisticChange zmiana;
        if (student.getStatistic(typeOfStatistic)>requiredStatistic)
        {
             zmiana = new StatisticChange(typeOfStatistic, boost, days);
        }
        else
        {
             zmiana = new StatisticChange(typeOfStatistic, -boost, days);
        }
        student.addStatisticChange(zmiana);
    }
}
