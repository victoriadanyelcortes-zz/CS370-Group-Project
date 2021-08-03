public class Main {

    private static final SuperFactory SF = new SuperFactory();
    private static final MathClassFactory MathFactory = SF.getMathFactory();
    private static final PhysicsClassFactory PhysicsFactory = SF.getPhysicsFactory();
    private static final CompSciClassFactory CompSciFactory = SF.getCompSciFactory();
    private static final OtherClassFactory OtherFactory = SF.getOtherFactory();

    public static void main(String[] args) throws Exception {

        for(int i=0;i<CompSciFactory.getClass(370).getClassMaxCapacity();i++){
            CompSciFactory.getClass(320).addStudent("Student "+i);
            CompSciFactory.getClass(370).addStudent("Student "+i);
        }
        CompSciFactory.getClass(320).PrintClassInformation();
        CompSciFactory.getClass(340).PrintClassInformation();
        CompSciFactory.getClass(370).PrintClassInformation();
    }
}