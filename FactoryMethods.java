import java.util.ArrayList;

public interface FactoryMethods {

    public void NotifyStudents(String Message);

    public void printClassesStringData();

    public void createClasses();

    public void printAllClassesInformation();

    public void searchClassLevel(int level);

    public Class getClass(int level) throws Exception;

    public void searchClassLevelRange(int levelStart ,int levelEnd);

}
