import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

// Observer Pattern by Victoria Cortes, Singleton by Steven Wen

public class Registrar implements MyObservable {
    protected final List<MyObserver> observers = new ArrayList<MyObserver>();

    //public Registrar() {}

    private static Registrar single_instance = null;

    //method to create Registrar object
    private Registrar(){};

    public static Registrar getInstance() {

        if(single_instance == null){
            single_instance = new Registrar();
        }

        return single_instance;
    }

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
        // Updating each observer of the number of seats left in a class
        for (MyObserver obs : observers) {
            obs.updateSeats(seats, c);
        }

    }

    @Override
    public void notifyFull(Class c) {
        // Updating each observer that a class is full
        for (MyObserver obs : observers) {
            obs.full(c);
        }
    }
}