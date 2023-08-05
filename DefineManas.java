import java.util.*;
import java.io.File;

public class DefineManas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner bad = null;
        try {
            File file = new File("badwords.txt");
            bad = new Scanner(file);
        } catch (Exception e) {
            System.out.println("File not found");
        }

        String lines = bad.nextLine();
        int no = Integer.parseInt(lines);
        System.out.println(no);
        String arr[] = new String[no];
        for (int i = 0; i < no; i++) {
            arr[i] = bad.nextLine();
        }

        System.out.print("Enter the Person's name: ");
        String name = sc.nextLine();
        sc.close();
        if (name == "" || name == " " || name == null) {
            name = "Manas";
        }
        System.out.println(" ");
        System.out.print(name + " is a ");
        System.out.print(arr[(int) (Math.random() * no)] + ".\n");

    }
}