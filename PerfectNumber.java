import java.util.*;

public class PerfectNumber {
    static Boolean Perfect(int num){
        int tempSum = 0;
        int divlimit = num / 2;
        for(int i = 1; i <= divlimit; i++){
            if(num % i == 0){
                tempSum += i;
            }
        }
        if (tempSum == num){
            return true;
        } else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Start of the range: ");
        int start = sc.nextInt();
        System.out.println(" ");
        System.out.print("Enter the End of the range: ");
        int end = sc.nextInt();
        sc.close();
        System.out.println(" ");
        System.out.println("The perfect numbers in the range " + start + " to " + end + " are:");
        for(int num = start; num <= end; num++){
            if(Perfect(num)){
                System.out.println(num);
            }
        }
    }
}