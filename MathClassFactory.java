import java.util.ArrayList;

public class MathClassFactory implements FactoryMethods {
    private ArrayList<String> MathClassList;
    private ArrayList<MathClass> MathClassObjectList = new ArrayList<MathClass>(40);

    public MathClassFactory(ArrayList<String> classList){
        MathClassList = classList;
        createClasses();
    }

    @Override
    public void createClasses() {
        String[] ClassDataArray;
        for(String currentLine: MathClassList){
            ClassDataArray = currentLine.split(",");
            MathClassObjectList.add(new MathClass(ClassDataArray));
        }
    }

    @Override
    public void NotifyStudents(String Message) {
        System.out.println(Message);
    }

    @Override
    public void printClassesStringData() {
        System.out.println("Math Classes Internal Data:");
        for(String classData: MathClassList){
            System.out.println(classData);
        }
    }

    @Override
    public void printAllClassesInformation() {
        for(MathClass mathclass: MathClassObjectList) {
            mathclass.PrintClassInformation();
        }
    }

    @Override
    public void searchClassLevel(int level) {
        for(MathClass mathclass: MathClassObjectList) {
            if(mathclass.ClassLevel==level) {
                mathclass.PrintClassInformation();
            }
        }
    }

    @Override
    public Class getClass(int level) throws Exception{
        for(MathClass mathclass: MathClassObjectList) {
            if(mathclass.ClassLevel==level) {
                return mathclass;
            }
        }
        throw new Exception("Class: "+level+" does not exist.");
    }

    @Override
    public void searchClassLevelRange(int levelStart, int levelEnd) {
        for(MathClass mathclass: MathClassObjectList) {
            if(mathclass.ClassLevel>=levelStart && mathclass.ClassLevel<=levelEnd) {
                mathclass.PrintClassInformation();
            }
        }
    }

}