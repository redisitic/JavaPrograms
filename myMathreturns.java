import java.util.Scanner;

public class myMathreturns {
    public static float e = 2.718281828459045f;
    public static float power(float x, int y){
        float z = 1f;
        for (int i = 0; i < y; i++){
            z = z * x;
        }
        return z;
    }

    public static int fact(int x){
        int y = 1;
        for (int i = x; i > 0; i--){
            y = y * i;
        }
        return y;
    }
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter the value of x: ");
        float x = sn.nextFloat();
        System.out.println("");
        System.out.print("Enter the va;lue of n: ");
        int n = sn.nextInt();
        sn.close();
        if(n < 1 || x < 0){
            System.out.println("X and N must be positive");
            System.exit(1);
        }
        float result = 1f;
        for (int i = 1; i <= n; i++){
            float dn = fact(i - 1);
            float nn = 1;
            float tempresult = (power(x, i) * nn);
            result = result + (tempresult / dn);
        }
        System.out.println("");
        System.out.print("The value of Mclauren's Expansion of  (1+x)^n = " + result);
    }
}