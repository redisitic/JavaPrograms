import java.util.*;
public class Circle {
    static double Circumfrence(double radius){
        double circumfrence = 2 * Math.PI * radius;
        return circumfrence;
    }
    static double Area(double radius){
        double area = Math.PI * radius * radius;
        return area;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();
        sc.close();
        double circumfrence = Circumfrence(radius);
        double Area = Area(radius);
        System.out.println("The circumfrence of the circle is: " + circumfrence);
        System.out.println("The area of the circle is: " + Area);
    }
}
