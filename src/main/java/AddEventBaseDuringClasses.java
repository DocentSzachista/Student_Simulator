
import java.util.ArrayList;
import java.util.List;


public class AddEventBaseDuringClasses
{
    private String[] description={"Pierwsze zajęcia prowadzący zaczyna od wejściówki aby sprawdzić Twoją dotychczasową wiedzę",
            "Studentów pilnuje doktor, który ma dobre serce i rzuca drobnymi podpowiediami.",
            "Prowadzacy nie wziął na wejściówkę okularów a ma dużą wadę. Aż żal sobie nie pomóc",
            "Zepsuł się rzutnik Studen podszedł do prowadzącego i próbuje podłączyć odpięty kabel",
            "Na kolokwium pojawiły się te same pytania co w poprzednim roku",
            "Prowadzący wita Cię naprawdę trudną wejściówką. Próbujesz ściągnąć by ją zdać",
            "Prowadzący ma rozkminę na temat obecnej sytuacji gospodarczej na świecie. Studen udziela się w dyskusji, licząc na fory u prowadzącego.",
            "Studen przychodzi na zaliczenie przedmiotu będąc nieprzygoowanym. Próbuje przypomnieć sobie materiał z wykładów w trakcie pisania.",
            "Student pisze egzamin",
            "Student obraża prowadzącego witając go używając stopnia naukowego niższego od posiadanego."};


    private StatisticType[] typeOfStatisticRequired = { StatisticType.Inteligencja,
            StatisticType.Inteligencja, StatisticType.Spryt,  StatisticType.Inteligencja, StatisticType.Spryt,  StatisticType.Spryt,StatisticType.Spryt, StatisticType.Inteligencja, StatisticType.Inteligencja, StatisticType.Spryt };
    private int[] requiredStats = {3, 4, 1, 4, 5, 4, 6, 8, 6, 10 };

    private List<ScientificEvent> listAfterSchool = new ArrayList<ScientificEvent>();
    public AddEventBaseDuringClasses()
    {
        for(int i=0; i<10; i++)
        {
            listAfterSchool.add(new ScientificEvent(description[i], typeOfStatisticRequired[i], requiredStats[i]));
        }
    }

    public List<ScientificEvent> getListAfterSchool() {
        return listAfterSchool;
    }
}
