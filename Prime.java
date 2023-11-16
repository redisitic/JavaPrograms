import java.util.*;

public class Prime{
    static void printPrime(int n){
        Boolean[] prime = new Boolean[n+1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }
        int p = 2;
        while (p * p <= n) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
            p++;
        }
        for (int q = 2; q <= n; q++) {
            if (prime[q]) {
                System.out.println(q);
            }
        }
    }

    public static void main(String Args[]){
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter the number to find primes upto: ");
        int num = sn.nextInt();
        sn.close();
        printPrime(num);
    }
}
