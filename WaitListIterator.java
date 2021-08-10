import java.util.LinkedList;
import java.util.Queue;

// The WaitListIterator implements the Iterator interface which contains the methods next and hasNext
public class WaitListIterator implements Iterator{
    private Queue<Student> WaitList = new LinkedList<Student>();
    
    // The WaitListIterator takes in a queue of students in the contructor  
    public WaitListIterator(Queue<Student> WaitList){
        this.WaitList = WaitList;
    }

    @Override
    public boolean hasNext() {
        if(WaitList.peek() != null) return true;
        else return false;
    }

    @Override
    public Object next() {
        return WaitList.poll();
    }
}
