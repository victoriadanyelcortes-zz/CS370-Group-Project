import java.util.ArrayList;

public class PhysicsClassFactory implements FactoryMethods {
    private ArrayList<String> PhysicsClassList;
    private ArrayList<PhysicsClass> PhysicsClassObjectList = new ArrayList<PhysicsClass>(40);

    public PhysicsClassFactory(ArrayList<String> classList) {
        PhysicsClassList = classList;
        createClasses();
    }

    @Override
    public void createClasses() {
        String[] ClassDataArray;
        for(String currentLine: PhysicsClassList){
            ClassDataArray = currentLine.split(",");
            PhysicsClassObjectList.add(new PhysicsClass(ClassDataArray));
        }
    }

    @Override
    public void NotifyStudents(String Message) {
        System.out.println(Message);
    }

    @Override
    public void printClassesStringData() {
        System.out.println("Physics Classes Internal Data:");
        for(String classData: PhysicsClassList) {
            System.out.println(classData);
        }
    }

    @Override
    public void printAllClassesInformation() {
        for(PhysicsClass physicsclass: PhysicsClassObjectList) {
            physicsclass.PrintClassInformation();
        }
    }

    @Override
    public void searchClassLevel(int level) {
        for(PhysicsClass physicsclass: PhysicsClassObjectList){
            if(physicsclass.ClassLevel==level){
                physicsclass.PrintClassInformation();
            }
        }
    }

    @Override
    public Class getClass(int level) throws Exception{
        for(PhysicsClass physicsclass: PhysicsClassObjectList){
            if(physicsclass.ClassLevel==level){
                return physicsclass;
            }
        }
        throw new Exception("Class: "+level+" does not exist.");
    }

    @Override
    public void searchClassLevelRange(int levelStart, int levelEnd) {
        for(PhysicsClass physicsclass: PhysicsClassObjectList){
            if(physicsclass.ClassLevel>=levelStart && physicsclass.ClassLevel<=levelEnd){
                physicsclass.PrintClassInformation();
            }
        }
    }

}