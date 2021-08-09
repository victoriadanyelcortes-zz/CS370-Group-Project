import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverPatternTest {

    // Testing the classes Student and Registrar as Observer and Observable Respectively
    @Test
    public void test() {
        Registrar registrar = new Registrar();
        MyObserver student = new Student(registrar,"Notso V. Studious");
        MyObserver stud = new Student(registrar, "Studious Studente");
        registrar.addListener(student);
        registrar.addListener(stud);

        // Assertion to make sure attaching observers works properly
        assertEquals(2, registrar.observers.size());

        // Assertion to ensure removing observers works properly
        registrar.removeListener(student);
        assertEquals(1,registrar.observers.size());
    }

}