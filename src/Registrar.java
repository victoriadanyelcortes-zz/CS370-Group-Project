import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

public class Registrar implements MyObservable {
    protected final List<MyObserver> observers = new ArrayList<MyObserver>();

    public Registrar() {}

    public void addToClass(Student s, Class c) {
        if (c.classRoster.size() < c.classCap) {
            c.classRoster.add(s);
            c.seatsTaken--;
            notif(c.seatsTaken, c);
        } else {
            c.isFull = true;
            notifyFull(c);
        }
    }

    public void dropFromClass(Student s, Class c) {
        if (c.isFull) {
            c.isFull = false;
            c.seatsTaken++;
            notif(c.seatsTaken, c);
        }
        c.classRoster.remove(s);
    }

    @Override
    public void addListener(MyObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeListener(MyObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notif(int seats, Class c) {
        for (MyObserver obs : observers) {
            obs.updateSeats(seats, c);
        }

    }

    @Override
    public void notifyFull(Class c) {
        for (MyObserver obs : observers) {
            obs.full(c);
        }
    }
}