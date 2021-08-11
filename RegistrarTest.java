import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//J-Unit test to insure that the singleton class
//is able to create an object
class RegistrarTest {
    @Test
    public void main() {
        // A simple test to insure a single object through the singleton class
        Registrar registrar = Registrar.getInstance();


        if(registrar != null){
            System.out.println("Object has been created and exists");
        }

    }

}