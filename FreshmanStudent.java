public class FreshmanStudent implements MyStrategy {



    @Override
    public String getStudentInfo(String name) {
        String result = "Student name is: " + name + " and there grade level is freshman";
        return result;
    }
}
