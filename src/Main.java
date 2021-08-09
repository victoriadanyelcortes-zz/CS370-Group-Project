public class Main {

    public static void sample() {
        Registrar registrar = new Registrar();
        MyObserver s1 = new Student(registrar , "Student 1");
        MyObserver s2 = new Student(registrar, "Student 2");
        MyObserver s3 = new Student(registrar, "Student 3");
        MyObserver s4 = new Student(registrar, "Student 4");
        MyObserver s5 = new Student(registrar, "Student 5");
        Class c = new Class("CSCI 370");
        Class cs = new Class("CSCI 331");

        registrar.addListener(s1);
        registrar.addListener(s2);
        registrar.addListener(s3);
        registrar.addListener(s4);
        registrar.addListener(s5);
        registrar.removeListener(s5);


        ((Student) s1).addClass(c);
        ((Student) s2).addClass(c);
        ((Student) s3).addClass(c);
        ((Student)s4).addClass(c);
        if (!c.isFull) throw new AssertionError();
        ((Student) s1).dropClass(c);
        if (c.isFull) throw new AssertionError();
        ((Student) s4).addClass(c);
        ((Student) s1).addClass(c);
    }

    public static void main(String[] args) {
        sample();

    }
}
