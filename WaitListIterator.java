import java.util.LinkedList;
import java.util.Queue;

public class WaitListIterator implements Iterator{
    private Queue<Student> WaitList = new LinkedList<Student>();

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
