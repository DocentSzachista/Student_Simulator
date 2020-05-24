/**
 * Klasa ScientificEvent reprezentuje wydarzenie podczas zajec z okreslonego kursu.
 * Sprawdza wybrany typ statystyki, jezeli bedzie spelniala wymog to dodaje ocene pozytywna,
 * a jesli nie to dodaje ocene negatywna do przedmiotu.
 */

public class ScientificEvent extends EventBase{
    private Subject subject;

    /**
     * Stworzenie instancji ScientificEvent
     * @param description opis wydarzenia
     * @param typeOfStatistic typ sprawdzanej statystyki
     * @param requirements wymagana wartosc statystyki
     */
  public ScientificEvent(String description, StatisticType typeOfStatistic, int requirements ){
      this.description=description;
      this.typeOfStatistic=typeOfStatistic;
      this.requiredStatistic=requirements;
  }

    /**
     * Metoda sprawdza czy student spełnia wymogi wydarzenia
     * @param student na którym ma zostać dokonane sprawdzenie.
     */
    @Override
    public void evaluateStudent(Student student)
    {
        System.out.println(description);
        int statDifference = student.getStatistic(typeOfStatistic) - requiredStatistic;
        if(statDifference >= 0)
        {
            int markToAdd = 3;
            if(statDifference >= requiredStatistic)
                markToAdd = 5;
            else if((float)statDifference >= (float)requiredStatistic * .5f)
                markToAdd = 4;

            subject.addMark(markToAdd);
            System.out.println("Udało się, otrzymałeś ocene: " + markToAdd);
        }
        else
        {
            subject.addMark(2);
            System.out.println("Nie udało się, otrzymałeś ocene: 2");
        }
    }

    /**
     * Przyporzadkowanie wydarzenia przedmiotowi
     * @param subject przedmiot.
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
