import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

//this is a singleton class which only allows a Registrar type object to be instantiated once

//this Registrar class allows a user to update data in the registrar, allowing students to be
//added/dropped from classes and the number of available seats left in a class.

public class Registrar implements MyObservable {
    private final List<MyObserver> observers = new ArrayList<MyObserver>();

    //the following two methods are set as private in order to restrict access to
    //object creation methods, insuring only a single object of this class type can be created
    //sets the initial value to null
    private static Registrar single_instance = null;

    //method to create Registrar object
    private Registrar(){};

    //a public method intended to place a conditional check to see if the object already exists
    //and only if not, will the object be created.
    public static Registrar getInstance() {

        if(single_instance == null){
            single_instance = new Registrar();
        }

        return single_instance;
    }

    //this method adds a student to a class, unless the class is full
    //if the class is full the student is then notified
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

    //this method drops students from classes, removing them from the roster
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

    //this method updates and displays the amount of seats still available in a class
    @Override
    public void notif(int seats, Class c) {
        for (MyObserver obs : observers) {
            obs.updateSeats(seats, c);
        }

    }

    //this method updates and displays that a class is full
    @Override
    public void notifyFull(Class c) {
        for (MyObserver obs : observers) {
            obs.full(c);
        }
    }
}