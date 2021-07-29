
public class Student implements MyObserver {
    Registrar r;
    String name;
    public Student (Registrar r, String name) {
        this.r = r;
        this.name = name;
    }

    public void addClass(Class c) {
        r.addToClass(this, c);
    }

    public void dropClass(Class c) {
        r.dropFromClass(this, c);
    }

    @Override
    public void updateSeats(int seatsLeft, Class c) {
        System.out.println(name + ": The number of seats left in" + c.name + " are: " + seatsLeft);
    }

    @Override
    public void full(Class c) {
        System.out.println(name + ":" + c.name + " is now full!");
    }
}
