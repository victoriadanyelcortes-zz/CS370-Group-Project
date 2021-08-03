import java.util.ArrayList;

public abstract class Class {

    private final int ClassSubjectIndex=0;
    private final int ClassLevelIndex = 1;
    private final int ClassKeyIndex=2;
    private final int ClassMaxCapacityIndex=3;
    private final int ClassInstructorIndex=4;
    private final int StartTimeClassIndex=5;
    private final int EndTimeClassIndex=6;

    protected String ClassSubject="";
    protected Integer ClassLevel=0;
    protected String ClassID="";
    protected String ClassInstructor="";
    protected String ClassStartTime="TBA";
    protected String ClassEndTime="TBA";
    protected Integer ClassMaxCapacity=0;
    protected Integer NumberOfStudentsInClass=0;
    protected ArrayList<String> ArrayForStudents = new ArrayList<String>(30);

    protected void setData(String[] splitData){
        ClassSubject=splitData[ClassSubjectIndex];
        ClassLevel=Integer.parseInt(splitData[ClassLevelIndex]);
        ClassID=splitData[ClassKeyIndex];
        ClassMaxCapacity=Integer.parseInt(splitData[ClassMaxCapacityIndex]);
        ClassInstructor=splitData[ClassInstructorIndex];
        ClassStartTime=splitData[StartTimeClassIndex];
        ClassEndTime=splitData[EndTimeClassIndex];
    }

    public void PrintClassInformation(){
        System.out.println("*****************************");
        System.out.println(ClassSubject+" "+ClassLevel+" "+ClassInstructor);
        System.out.println("Start: "+ClassStartTime+" End: "+ClassEndTime);
        System.out.println("Remaining Capacity: "+(ClassMaxCapacity-NumberOfStudentsInClass));

    }

    public void addStudent(String StringPlaceHolder_StudentObject_StudentName) throws Exception{
        if(NumberOfStudentsInClass<ClassMaxCapacity){
            NumberOfStudentsInClass++;
            ArrayForStudents.add(StringPlaceHolder_StudentObject_StudentName);
        }else throw new Exception("Unable to Add Student, Max Capacity Reached for: "+ClassSubject+" "+ClassLevel+" "+ClassInstructor);

    }

    public void removeStudent(String StringPlaceHolder_StudentObject_StudentName) {
        for(String Student: ArrayForStudents){
            if(Student.equals(StringPlaceHolder_StudentObject_StudentName)){
                NumberOfStudentsInClass--;
                ArrayForStudents.remove(Student);
                return;
            }
        } System.out.println("Student "+StringPlaceHolder_StudentObject_StudentName+" not found");
    }

    public void printStudents(){
        for(String student: ArrayForStudents){
            System.out.println(student);
        }
    }

    public String getClassSubject() {
        return ClassSubject;
    }

    public void setClassSubject(String classSubject) {
        ClassSubject = classSubject;
    }

    public Integer getClassLevel() {
       return ClassLevel;
    }

    public void setClassLevel(Integer classLevel) {
        ClassLevel = classLevel;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String classID) {
        ClassID = classID;
    }

    public String getClassInstructor() {
        return ClassInstructor;
    }

    public void setClassInstructor(String classInstructor) {
        ClassInstructor = classInstructor;
    }

    public String getClassStartTime() {
        return ClassStartTime;
    }

    public void setClassStartTime(String classStartTime) {
        ClassStartTime = classStartTime;
    }

    public String getClassEndTime() {
        return ClassEndTime;
    }

    public void setClassEndTime(String classEndTime) {
        ClassEndTime = classEndTime;
    }

    public Integer getClassMaxCapacity() {
        return ClassMaxCapacity;
    }

    public void setClassMaxCapacity(Integer classMaxCapacity) {
        ClassMaxCapacity = classMaxCapacity;
    }

}