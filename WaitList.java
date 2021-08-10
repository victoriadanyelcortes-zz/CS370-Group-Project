import java.util.LinkedList;
import java.util.Queue;

// The WaitList class implements the Collection interface which contains the createIterator method
// This class uses a queue to store the collection of students
public class WaitList implements Collection{
    private Queue<Student> WaitList = new LinkedList<Student>();
    private int maxCapacity = 10;
    private int currentCapacity = 0;

    // Methods to append, remove, and clear students
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

    // generate iterator
    @Override
    public Iterator createIterator(){
        return new WaitListIterator(WaitList);
    }
}
