import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddEventBase
{
    private File base;
    private List<EventAfterClasses> listAfterSchool = new ArrayList<EventAfterClasses>();
    public AddEventBase(String event)
    {
        this.base= new File(event);
        try
        {

            Scanner readFile = new Scanner(base);
            while (readFile.hasNextLine()) {
                String description = readFile.nextLine();
                String statisticType = readFile.nextLine();
                int required = Integer.parseInt(readFile.nextLine());
                listAfterSchool.add(new EventAfterClasses(description, StatisticType.valueOf(statisticType), required));
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

    public List<EventAfterClasses> getListAfterSchool() {
        return listAfterSchool;
    }

}
