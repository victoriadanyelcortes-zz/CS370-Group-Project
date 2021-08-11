
//This class implements MyStategy interface

public class SeniorStudent implements MyStrategy {


    @Override
    public String getStudentInfo(String name) {
        String result = "Student name is: " + name + " and there grade level is Senior";
        return result;
    }
}
