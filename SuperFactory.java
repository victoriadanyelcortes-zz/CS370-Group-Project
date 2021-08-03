import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SuperFactory{
    private final int  ExpectedNumberOfElementsPerLine=7;//***When Adding or removing a data element from file to be read update this value ***
    private final int ClassSubjectIndex=0;
    private final int ClassLevelIndex = 1;
    private final int ClassKeyIndex=2;
    private final int ClassMaxCapacityIndex=3;
    private final int ClassInstructorIndex=4;
    private final int StartTimeClassIndex=5;
    private final int EndTimeClassIndex=6;
    private static ArrayList<String> AllClassesList_StringData = new ArrayList<String>(200);
    private static ArrayList<String> MathClassesList_StringData = new ArrayList<String>(50);
    private static ArrayList<String> PHYSClassesList_StringData = new ArrayList<String>(50);
    private static ArrayList<String> CSClassesList_StringData = new ArrayList<String>(50);
    private static ArrayList<String> OtherClassesList_StringData = new ArrayList<String>(50);
    private static ArrayList<String> RejectedList = new ArrayList<String>(20);
    private MathClassFactory mathFactory=null;
    private PhysicsClassFactory physicsFactory=null;
    private CompSciClassFactory compSciFactory=null;
    private OtherClassFactory otherFactory=null;


    public SuperFactory(){
    readClassesTXTFile();
    createSubFactories();
    }

    private void readClassesTXTFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Supplied Classes.txt"));
            String CurrentLine;
            String[] LineDataSplit;
            while((CurrentLine=reader.readLine())!=null) {
                LineDataSplit=CurrentLine.split(",");
                if(currentLineIsValid(LineDataSplit)) {
                    AllClassesList_StringData.add(CurrentLine);
                    String Subject = LineDataSplit[ClassSubjectIndex];
                    switch (Subject){
                        case "MATH": MathClassesList_StringData.add(CurrentLine);
                                    break;
                        case "PHYS": PHYSClassesList_StringData.add(CurrentLine);
                                    break;
                        case "CS": CSClassesList_StringData.add(CurrentLine);
                                    break;
                        default: OtherClassesList_StringData.add(CurrentLine);
                                    break;
                    }
                }else{
                    RejectedList.add(CurrentLine);
                }
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean currentLineIsValid(String[] SplitLineValues){
        if(SplitLineValues.length!=ExpectedNumberOfElementsPerLine || SplitLineValues[ClassKeyIndex].length()!=36){return false;}
        try{
            Integer classLevel = Integer.parseInt(SplitLineValues[ClassLevelIndex]);
            Integer classCapacity = Integer.parseInt(SplitLineValues[ClassMaxCapacityIndex]);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void printAllClasses(){
        System.out.println("CLASS LIST SIZE: "+AllClassesList_StringData.size());
        for(String line: AllClassesList_StringData) {
            System.out.println(line);
        }
        System.out.println("REJECT LIST SIZE: "+RejectedList.size());
        for(String line: RejectedList) {
            System.out.println(line);
        }

    }

    public void printALLSubLists(){
        System.out.println("[--------------MATH SUBLIST--------------]");
            for(String Line: MathClassesList_StringData){
                System.out.println(Line);
            }
        System.out.println("[--------------PHYSC SUBLIST--------------]");
        for(String PLine: PHYSClassesList_StringData){
            System.out.println(PLine);
        }
            System.out.println("[-------------- CS SUBLIST--------------]");
        for(String CLine: CSClassesList_StringData){
            System.out.println(CLine);
        }
    }

    private void createSubFactories(){
        mathFactory = new MathClassFactory(MathClassesList_StringData);
        physicsFactory = new PhysicsClassFactory(PHYSClassesList_StringData);
        compSciFactory = new CompSciClassFactory(CSClassesList_StringData);
        otherFactory = new OtherClassFactory(OtherClassesList_StringData);
    }

    public MathClassFactory getMathFactory(){
        return mathFactory;
    }

    public PhysicsClassFactory getPhysicsFactory(){
        return physicsFactory;
    }

    public CompSciClassFactory getCompSciFactory(){
        return compSciFactory;
    }

    public OtherClassFactory getOtherFactory(){
        return otherFactory;
    }

}
