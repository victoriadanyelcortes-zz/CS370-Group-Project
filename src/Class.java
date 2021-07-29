import java.util.ArrayList;
import java.util.List;

public class Class {

    protected int classCap = 3;
    protected int seatsTaken = classCap;
    protected List<Student> classRoster = new ArrayList<Student>();
    protected boolean isFull;
    protected String name;

    public Class(String name) {
        this.name = name;
    }
}
