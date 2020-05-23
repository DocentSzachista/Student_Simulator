/**
 * Klasa Subject, przechowywująca informacje o przedmiocie oraz liczbę ocen Studenta
 *
 */
 import java.util.Random;
 import java.util.List;
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
	private  AddEventBaseDuringClasses Events= new AddEventBaseDuringClasses("EventDuringClassesBase.txt");
	/**
	 * Tworzenie nowej instancji przedmiotu o zadanej nazwie
	 *
	 */
	public Subject(String name)
	{
		this.name = name;
	}

	/**
	 * Dodanie nowej oceny
	 * @param mark ocena jaką student uzyskał
	 */
	public void addMark(float mark)
	{
		if(mark < 2 || mark > 5.5)
			throw new IllegalArgumentException("Mark has to be between 2 and 5.5, passed mark is: " + mark);

		marksSum += mark;
		marksAmount++;
	}

	/**
	 * Uzyskanie informacji o średniej ocen z kursu
	 * @return zwraca średnią jeśli student uzyskał jakąkolwiek ocenę
	 */
	public float getScore()
	{
		if(marksAmount == 0)
			return -1;

		return marksSum/marksAmount;
	}

	/**
	 * Zwraca informację czy student zdał przedmiot
	 * @return jeżeli student uzyskał średnią równą lub większą od 3.0 to zwraca informację, że zdał.
	 */
	public boolean isSubjectPassed()
	{
		return getScore() >= 3;
	}

	/**
	 * Zwraca nazwę przedmiotu
	 * @return nazwa tego przedmiotu
	 */
	@Override
	public String toString () {
		return name;
	}
	public void randomEvent(Student student)
	{
		Random random= new Random();
		List<ScientificEvent> lista = Events.getListAfterSchool();
		int losujElement= random.nextInt(lista.size()-1);
		 lista.get(losujElement).evaluateStudent(student);

	}

}
