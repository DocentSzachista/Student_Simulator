package simulation.event;

import simulation.student.StatisticType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Klasa dodająca bazy wydarzeń WeekendEvents i SchoolEvents.
 */
public class EventsDatabase
{
	private final List<Event> weekendEvents;
	private final List<Event> schoolEvents;

	public List<Event> getWeekendEvents()
	{
		return weekendEvents;
	}

	public List<Event> getSchoolEvents()
	{
		return schoolEvents;
	}

	/**
	 * Konstruktor klasy
	 */
	public EventsDatabase()
	{
		weekendEvents = dataBase("WeekendEvents.txt");
		schoolEvents = dataBase("SchoolEvents.txt");

	}
	private List<Event> dataBase(String fileName)
	{
		List<Event> events = new ArrayList<Event>();
		File file=new File(fileName);
		try
		{
			Scanner readFile = new Scanner(file);
			fileReadLoop(file, readFile, events, fileName);
			readFile.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("Błąd przy otwieraniu");
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			System.out.println("Błąd przy konwersji");
			e.printStackTrace();
		}
		return  events;
	}
	private void fileReadLoop(File file, Scanner readFile, List<Event> events, String fileName )
	{
		while (readFile.hasNextLine())
		{
			String description = readFile.nextLine();
			String statisticType = readFile.nextLine();
			int required = Integer.parseInt(readFile.nextLine());
			if(fileName.contains("WeekendEvents.txt"))
				events.add(new WeekendEvent(description, StatisticType.valueOf(statisticType), required));
			else if (fileName.contains("SchoolEvents.txt"))
				events.add(new SchoolEvent(description, StatisticType.valueOf(statisticType), required));
		}
	}
}
