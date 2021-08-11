public class Main {
    public static void main(String[] args) {
        Student A = new Student("Alice");
        Student B = new Student("Bob");
        Student C = new Student("Charlie");

        WaitList waitList = new WaitList();
        waitList.addStudent(A);
        waitList.addStudent(B);
        waitList.addStudent(C);

        Iterator iterator = waitList.createIterator();

        // This while loop will print out all the students in the waitlist by using the next and hasNext
        // methods from the iterator that was created
        while(iterator.hasNext() == true){
            Student student = (Student)iterator.next();
            System.out.println(student.getName());
        }
    }
}
