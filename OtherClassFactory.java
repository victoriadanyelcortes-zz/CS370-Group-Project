import java.util.ArrayList;

public class OtherClassFactory implements FactoryMethods {
    private ArrayList<String> OtherClassesList;
    private ArrayList<OtherClass> OtherClassObjectList = new ArrayList<OtherClass>(50);

    public OtherClassFactory(ArrayList<String> ClassList){
        OtherClassesList = ClassList;
        createClasses();
    }

    @Override
    public void createClasses() {
        String[] ClassDataArray;
        for(String currentLine: OtherClassesList){
            ClassDataArray = currentLine.split(",");
            OtherClassObjectList.add(new OtherClass(ClassDataArray));
        }
    }

    @Override
    public void NotifyStudents(String Message) {
        System.out.println(Message);
    }

    @Override
    public void printClassesStringData() {
        System.out.println("Other Classes Internal Data:");
        for(String classData: OtherClassesList) {
            System.out.println(classData);
        }
    }

    @Override
    public void printAllClassesInformation() {
        for(OtherClass otherClass: OtherClassObjectList){
            otherClass.PrintClassInformation();
        }
    }

    @Override
    public void searchClassLevel(int level) {
        for(OtherClass otherclass: OtherClassObjectList){
            if(otherclass.ClassLevel==level){
                otherclass.PrintClassInformation();
            }
        }
    }

    @Override
    public Class getClass(int level) throws Exception{
        for(OtherClass otherclass: OtherClassObjectList){
            if(otherclass.ClassLevel==level){
                return otherclass;
            }
        }
        throw new Exception("Class: "+level+" does not exist.");
    }

    @Override
    public void searchClassLevelRange(int levelStart, int levelEnd) {
        for(OtherClass otherclass: OtherClassObjectList){
            if(otherclass.ClassLevel>=levelStart && otherclass.ClassLevel<=levelEnd){
                otherclass.PrintClassInformation();
            }
        }
    }

}