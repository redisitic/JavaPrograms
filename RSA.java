import java.util.*;
public class RSA {
    static Double gcd(Double a, Double h){
        Double temp = 0.0;
        while(true){
            temp = a % h;
            if(temp == 0){
                return h;
            }
            a = h;
            h = temp;
        }
    }
    public static void main(String Args[]){
        Double p = 3.0;
        Double q = 7.0;
        Double n = p*q;
        Double e = 2.0;
        Double phi = (p-1)*(q-1);


        while(e < phi){
            if(gcd(e, phi) == 1){
                break;
            } else{
                e++;
            }
        }
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter the number to be envrypted: ");
        Double msg = sn.nextDouble();
        sn.close();


        Double encmsg = Math.pow(msg, e);
        encmsg = encmsg % n;
        System.out.println("Encrypted Message = " + encmsg);
    }
}

