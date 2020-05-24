import java.util.Random;
import java.util.List;

/**
 * Klasa Subject, przechowywujaca informacje o przedmiocie oraz liczbe ocen Studenta.
 * Sprawdza dla wylosowanego wydarzenia statystykę Studenta i po rozpatrzeniu dodaje
 * mu ocene.
 */
public class Subject
{
	/**
	 * Mazwa kursu
	 */
	private String name;
	/**
	 * Suma ocen z kursu
	 */
	private float marksSum;
	/**
	 * ilosc ocen z kursu
	 */
	private int marksAmount;
	private  AddEventBaseDuringClasses events= new AddEventBaseDuringClasses();
	/**
	 * Tworzenie nowej instancji przedmiotu o zadanej nazwie
	 * @param name nazwa przedmiotu
	 */
	public Subject(String name)
	{
		this.name = name;
	}

	/**
	 * Dodanie nowej oceny
	 * @param mark ocena jaka student uzyskal
	 */
	public void addMark(float mark)
	{
		if(mark < 2 || mark > 5.5)
			throw new IllegalArgumentException("Mark has to be between 2 and 5.5, passed mark is: " + mark);

		marksSum += mark;
		marksAmount++;
	}

	/**
	 * Uzyskanie informacji o sredniej ocen z kursu
	 * @return zwraca srednia jesli student uzyskal jakakolwiek ocenę
	 */
	public float getScore()
	{
		if(marksAmount == 0)
			return -1;

		return marksSum/marksAmount;
	}

	/**
	 * Zwraca informacje czy student zdal przedmiot
	 * @return jezeli student uzyskal średnią równą lub większą od 3.0 to zwraca informację, ze zdal.
	 */
	public boolean isSubjectPassed()
	{
		return getScore() >= 3;
	}

	/**
	 * Zwraca nazwe przedmiotu
	 * @return nazwa tego przedmiotu
	 */
	@Override
	public String toString () {
		return name;
	}
	public ScientificEvent randomEvent(Student student)
	{
		Random random= new Random();
		List<ScientificEvent> lista = events.getListAfterSchool();
		int index=random.nextInt(lista.size());
		ScientificEvent event =  lista.get(index);
		lista.remove(index);
		 return  event;


	}

}
