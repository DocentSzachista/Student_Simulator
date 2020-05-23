import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddEventBaseDuringClasses
{
    private File base;
    private List<ScientificEvent> listAfterSchool = new ArrayList<ScientificEvent>();
    public AddEventBaseDuringClasses(String event)
    {
        this.base= new File(event);
        try
        {

            Scanner readFile = new Scanner(base);
            while (readFile.hasNextLine()) {
                String description = readFile.nextLine();
                String statisticType = readFile.nextLine();
                int required = Integer.parseInt(readFile.nextLine());
                listAfterSchool.add(new ScientificEvent(description, StatisticType.valueOf(statisticType), required));
            }
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
    }

    public List<ScientificEvent> getListAfterSchool() {
        return listAfterSchool;
    }

}
