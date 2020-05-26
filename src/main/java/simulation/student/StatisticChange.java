package simulation.student;

/**
 * Klasa zarządzająca zmianami statystyk Studenta
 */
public class StatisticChange {
	private StatisticType statisticToChange;
	private int changeAmount;
	private int daysLeft;

	/**
	 * Stworzenie nowego obiektu zmiany statystyki
	 * @param statisticToChange typ statystyki która ma ulec zmianie
	 * @param changeAmount ilość o którą ma się zmienić
	 * @param removeAfter  po ilu dniach ma zostać usunięta
	 */
	public StatisticChange(StatisticType statisticToChange, int changeAmount, int removeAfter) {
		this.statisticToChange = statisticToChange;
		this.changeAmount = changeAmount;
		this.daysLeft = removeAfter;
	}

	/**
	 * Metoda sprawdzająca czy należy usunąć daną zmianę statystyki.
	 * @return informacja czy należy ją usunąć czy też nie
	 */
	public boolean shouldRemove() {
		daysLeft--;
		if(daysLeft <= 0)
			return true;
		else
			return false;
	}

	/**
	 * Metoda zwracająca wartość bonusu danego typu statystyki
	 * @param statistic typ statystyki
	 * @return ilość zmiany, jeżeli nie ma żadnego bonusu, zwróć 0
	 */
	public int getStatisticChange(StatisticType statistic) {
		if(statistic != statisticToChange)
			return 0;

		return changeAmount;
	}
}
