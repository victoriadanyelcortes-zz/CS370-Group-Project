import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String fName = scanner.nextLine();


        Context context = new Context(new FreshmanStudent());

        System.out.println("Freshman Student info : " + context.executeNameStrategy(fName));

        System.out.print("Enter student name: ");
        String sName = scanner.nextLine();


        Context context2 = new Context(new SeniorStudent());

        System.out.println("Senior Student info : " + context2.executeNameStrategy(sName));


    }
}
