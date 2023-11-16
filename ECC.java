import java.util.Scanner;
public class ECC{
    public static int modPow(int base, int exponent, int modulus) {
        if (modulus == 1) return 0;
        int result = 1;
        base = base % modulus;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }
        return result;
    }
    public static int findDiscreteLogarithm(int p, int a, int b, int xQ, int yQ, int xP, int yP) {
        int i = 1;
        int num = 0;
        int den = 0;
        int xr = xP;
        int yr = yP;
        while (true) {
            if (i == 1) {
                num = (3 * xP * xP + a);
                den = 2 * yP;
            } else {
                num = yr - yP;
                den = xr - xP;
            }
            if (den < 0) {
                num = -num;
                den = -den;
            }
            den = modPow(den, p - 2, p);
            int l = (num * den) % p;
            xr = (l * l - xP - xr + p) % p;
            yr = (l * (xP - xr) - yP + p) % p;
            System.out.println(i + "P = (" + xr + ", " + yr + ")");
            i++;
            if (xr == xQ && yr == yQ) {
                break;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter p: ");
        int p = sn.nextInt();
        System.out.print("Enter a: ");
        int a = sn.nextInt();
        System.out.print("Enter b: ");
        int b = sn.nextInt();
        System.out.print("Enter x coordinate of Q: ");
        int xQ = sn.nextInt();
        System.out.print("Enter y coordinate of Q: ");
        int yQ = sn.nextInt();
        System.out.print("Enter x coordinate of P: ");
        int xP = sn.nextInt();
        System.out.print("Enter y coordinate of P: ");
        int yP = sn.nextInt();
        sn.close();
        int steps = findDiscreteLogarithm(p, a, b, xQ, yQ, xP, yP);
        System.out.println("Number of steps taken: " + steps);
    }
}
