import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddEventAfterClassesBase
{
    private String[] description ={"Wyjście na piwo z kolegami ze starszego rocznika. Jeśli studenta polubią to podzielą się notatkami.",
            "Poznanie ziomka z wyższego roku, który potrzebuje pomocy z programem, dzięki czemu student zdobywa nowe umiejętności.",
            "Nawiedza Cię duch sławnego magistra z brodą, dzięki któremu jesteś w stanie się uczyć po zajęciach.",
            "Impreza na Wyspie. Znowu student nie uczy się a imprezuje.",
            "Zostajesz mianowany królem wyspy. Dzięki temu dostajesz notatki i nie musisz się uczyć.",
            "Tramwaj się wykoleił. Nie masz czasu się pouczyć.",
            "Szukając opracowań na internecie Student pobiera wirusa. Jeśli podstępem go nie wyizoluje skończy bez komputera na 2 dni.",
            "Zamiast się uczyć Student gra cały dzień w grę."};
    private StatisticType[] typeOfStatisticRequired={StatisticType.Spryt, StatisticType.Inteligencja, StatisticType.Inteligencja, StatisticType.Lenistwo, StatisticType.Lenistwo, StatisticType.Inteligencja, StatisticType.Spryt, StatisticType.Lenistwo};
    private int[] requiredStats = {3 , 4, 5, 10, 3, 10, 6, 10};
    private List<EventAfterClasses> listAfterSchool = new ArrayList<EventAfterClasses>();
    public AddEventAfterClassesBase()
    {
        for(int i=0; i<8; i++)
        {
            listAfterSchool.add(new EventAfterClasses(description[i], typeOfStatisticRequired[i], requiredStats[i]));
        }
    }

    public List<EventAfterClasses> getListAfterSchool() {
        return listAfterSchool;
    }

}
