package simulation.event;

import simulation.student.StatisticType;

import java.util.Arrays;
import java.util.List;

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

	public EventsDatabase()
	{
		weekendEvents = Arrays.asList(
				new WeekendEvent("Wyjście na piwo z kolegami ze starszego rocznika. Jeśli studenta polubią to podzielą się notatkami.", StatisticType.Spryt, 3),
				new WeekendEvent("Poznanie ziomka z wyższego roku, który potrzebuje pomocy z programem, dzięki czemu student zdobywa nowe umiejętności.", StatisticType.Inteligencja, 4),
				new WeekendEvent("Nawiedza Cię duch sławnego magistra z brodą, dzięki któremu jesteś w stanie się uczyć po zajęciach.", StatisticType.Inteligencja, 5),
				new WeekendEvent("Impreza na Wyspie. Znowu student nie uczy się a imprezuje.", StatisticType.Lenistwo, 10),
				new WeekendEvent("Zostajesz mianowany królem wyspy. Dzięki temu dostajesz notatki i nie musisz się uczyć.", StatisticType.Lenistwo, 3),
				new WeekendEvent("Tramwaj się wykoleił. Nie masz czasu się pouczyć.", StatisticType.Inteligencja, 10),
				new WeekendEvent("Szukając opracowań na internecie student pobiera wirusa. Jeśli podstępem go nie wyizoluje skończy bez komputera na 2 dni.", StatisticType.Spryt, 6),
				new WeekendEvent("Zamiast się uczyć student gra cały dzień w grę.", StatisticType.Lenistwo, 10)
				);

		schoolEvents = Arrays.asList(
				new SchoolEvent("Pierwsze zajęcia prowadzący zaczyna od wejściówki aby sprawdzić Twoją dotychczasową wiedzę", StatisticType.Inteligencja, 3),
				new SchoolEvent("Studentów pilnuje doktor, który ma dobre serce i rzuca drobnymi podpowiediami.", StatisticType.Inteligencja, 4),
				new SchoolEvent("Prowadzacy nie wziął na wejściówkę okularów a ma dużą wadę. Aż żal sobie nie pomóc", StatisticType.Spryt, 1),
				new SchoolEvent("Zepsuł się rzutnik studen podszedł do prowadzącego i próbuje podłączyć odpięty kabel", StatisticType.Inteligencja, 4),
				new SchoolEvent("Na kolokwium pojawiły się te same pytania co w poprzednim roku", StatisticType.Spryt, 5),
				new SchoolEvent("Prowadzący wita Cię naprawdę trudną wejściówką. Próbujesz ściągnąć by ją zdać", StatisticType.Spryt, 4),
				new SchoolEvent("Prowadzący ma rozkminę na temat obecnej sytuacji gospodarczej na świecie. Studen udziela się w dyskusji, licząc na fory u prowadzącego.", StatisticType.Spryt, 6),
				new SchoolEvent("Student przychodzi na zaliczenie przedmiotu będąc nieprzygoowanym. Próbuje przypomnieć sobie materiał z wykładów w trakcie pisania.", StatisticType.Inteligencja, 8),
				new SchoolEvent("Student pisze egzamin.", StatisticType.Inteligencja, 6),
				new SchoolEvent("Student obraża prowadzącego witając go używając stopnia naukowego niższego od posiadanego.", StatisticType.Spryt, 10)
				);
	}
}
