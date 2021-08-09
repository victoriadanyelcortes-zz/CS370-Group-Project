import java.util.LinkedList;
import java.util.Queue;

public class WaitList implements Collection{
    private Queue<Student> WaitList = new LinkedList<Student>();
    private int maxCapacity = 10;
    private int currentCapacity = 0;

    public void addStudent(Student student){
        if(currentCapacity < maxCapacity){
            WaitList.add(student);
            currentCapacity++;
        }
        else return;
    }

    public void registerNextStudent(){
        WaitList.remove();
    }

    public void clearList(){
        WaitList.clear();
    }

    //generate iterator
    @Override
    public Iterator createIterator(){
        return new WaitListIterator(WaitList);
    }
}
