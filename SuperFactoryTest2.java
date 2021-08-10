import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SuperFactoryTest2 {
    SuperFactory sf = new SuperFactory();

    @org.junit.jupiter.api.Test
    void printAllClasses() {
        sf.printAllClasses();
    }

    @org.junit.jupiter.api.Test
    void printALLSubLists() {
        sf.printALLSubLists();
    }

    @org.junit.jupiter.api.Test
    void getMathFactory() {
       sf.getMathFactory().printAllClassesInformation();
    }

    @org.junit.jupiter.api.Test
    void getPhysicsFactory() {
       sf.getPhysicsFactory().printAllClassesInformation();
    }

    @org.junit.jupiter.api.Test
    void getCompSciFactory() {
       sf.getCompSciFactory().printAllClassesInformation();
    }

    @org.junit.jupiter.api.Test
    void getOtherFactory() {
      sf.getOtherFactory().printAllClassesInformation();
    }

}