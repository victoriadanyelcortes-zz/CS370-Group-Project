public class Student implements MyObserver {
    Registrar r;
    String name;
    
    public Student(String name) {
        this.name = name;
    }
    
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
        // Printing out the notification received from observable to simulate receiving the notification
        System.out.println(name + ": The number of seats left in " + c.name + " are: " + seatsLeft);
    }

    @Override
    public void full(Class c) {
        // Printing out the notification received from observable to simulate receiving the notification
        System.out.println(name + ":" + c.name + " is full!");
    }
    
    public String getName() {
        return name;
    }
}
