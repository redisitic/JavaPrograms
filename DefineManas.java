import java.util.*;
public class DefineManas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Person's name: ");
        String name = sc.nextLine();
        sc.close();
        if(name == "" || name == " " || name == null){
            name = "Manas";
        }
        System.out.println(" "); 
        System.out.print(name + " is ");
        String[] strAr = {"kutta", "bhenchod", "mawali", "bhosdike", "madarchod", "baap ki chut", "saala", "bhen ka loda", "chutiya"};
        int arlen = strAr.length;
        for(int i = 0; i < arlen; i++){
            int len1 = arlen - 1;
            int len2 = arlen - 2;
            System.out.print(strAr[i]);
            if(i == len2){
                System.out.print(" and ");
            }else if(i == len1){
                System.out.print(".");
            }else {
                System.out.print(", ");
            }
        }
    }
}