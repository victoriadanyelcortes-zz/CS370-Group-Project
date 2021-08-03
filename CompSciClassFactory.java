import java.util.ArrayList;

public class CompSciClassFactory implements FactoryMethods {
    private ArrayList<String> CompSciClassList;
    private ArrayList<CompSciClass> ComputerScienceObjectList = new ArrayList<CompSciClass>(50);

    public CompSciClassFactory(ArrayList<String> classList){
        CompSciClassList=classList;
        createClasses();
    }

    @Override
    public void createClasses() {
        String[] ClassDataArray;
        for(String currentLine: CompSciClassList){
            ClassDataArray = currentLine.split(",");
            ComputerScienceObjectList.add(new CompSciClass(ClassDataArray));
        }
    }

    @Override
    public void NotifyStudents(String Message) {
        System.out.println(Message);
    }

    @Override
    public void printClassesStringData() {
        System.out.println("COMPUTER SCIENCE CLASSES:");
        for(String classData: CompSciClassList){
            System.out.println(classData);
        }
    }

    @Override
    public void printAllClassesInformation() {
        for(CompSciClass computerScienceClass: ComputerScienceObjectList){
            computerScienceClass.PrintClassInformation();
        }
    }

    @Override
    public void searchClassLevel(int level) {
        for(CompSciClass computerScienceClass: ComputerScienceObjectList){
           if(computerScienceClass.ClassLevel==level){
               computerScienceClass.PrintClassInformation();
           }
        }
    }

    @Override
    public Class getClass(int level) throws Exception {
        for(CompSciClass computerScienceClass: ComputerScienceObjectList){
            if(computerScienceClass.ClassLevel==level){
                return computerScienceClass;
            }
        }
        throw new Exception("Class: "+level+" does not exist.");
    }

    @Override
    public void searchClassLevelRange(int levelStart, int levelEnd) {
        for(CompSciClass computerScienceClass: ComputerScienceObjectList){
            if(computerScienceClass.ClassLevel>=levelStart && computerScienceClass.ClassLevel<=levelEnd){
                computerScienceClass.PrintClassInformation();
            }
        }
    }

}