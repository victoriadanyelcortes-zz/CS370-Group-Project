public class Main {

    public static void test() {
        Registrar registrar = new Registrar();
        Student s1 = new Student(registrar , "Student 1");
        Student s2 = new Student(registrar, "Student 2");
        Student s3 = new Student(registrar, "Student 3");
        Student s4 = new Student(registrar, "Student 4");
        Class c = new Class();

        registrar.addListener(s1);
        registrar.addListener(s2);
        registrar.addListener(s3);
        registrar.addListener(s4);



        s1.addClass(c);
        s2.addClass(c);
        s3.addClass(c);
        s4.addClass(c);


    }

    public static void main(String[] args) {
        test();

    }
}
