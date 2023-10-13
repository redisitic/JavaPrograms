import java.io.PrintStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class Employee {
   String name;
   int id;
   double salary;

   Employee(String var1, int var2, double var3) {
      this.name = var1;
      this.id = var2;
      this.salary = var3;
   }

   static void Create(Vector<Employee> var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("Enter the number of employees");
      int var2 = var1.nextInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         System.out.println("Enter the name of the employee");
         String var4 = var1.next();
         System.out.println("Enter the E_Id of the employee");
         int var5 = var1.nextInt();
         System.out.println("Enter the salary of the employee");
         double var6 = var1.nextDouble();
         Employee var8 = new Employee(var4, var5, var6);
         var0.add(var8);
      }

      Collections.sort(var0, new Employee$1());
   }

   static void Insert(Vector<Employee> var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("Enter the name of the employee");
      String var2 = var1.next();
      System.out.println("Enter the E_Id of the employee");
      int var3 = var1.nextInt();
      System.out.println("Enter the salary of the employee");
      double var4 = var1.nextDouble();
      Employee var6 = new Employee(var2, var3, var4);
      var0.add(var6);
      Collections.sort(var0, new Employee$2());
   }

   static void deleteByEName(Vector<Employee> var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("Enter the name of the employee to be deleted");
      String var2 = var1.next();

      for(int var3 = 0; var3 < var0.size(); ++var3) {
         if (((Employee)var0.get(var3)).name.equals(var2)) {
            var0.remove(var3);
            break;
         }
      }

   }

   static void deleteByEId(Vector<Employee> var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("Enter the E_Id of the employee to be deleted");
      int var2 = var1.nextInt();

      for(int var3 = 0; var3 < var0.size(); ++var3) {
         if (((Employee)var0.get(var3)).id == var2) {
            var0.remove(var3);
            break;
         }
      }

   }

   static void display(Vector<Employee> var0) {
      for(int var1 = 0; var1 < var0.size(); ++var1) {
         PrintStream var10000 = System.out;
         String var10001 = ((Employee)var0.get(var1)).name;
         var10000.println("Name: " + var10001 + " E_Id: " + ((Employee)var0.get(var1)).id + " Salary: " + ((Employee)var0.get(var1)).salary);
      }

   }

   public static void main(String[] var0) {
      Vector var1 = new Vector();
      Scanner var2 = new Scanner(System.in);

      int var3;
      do {
         System.out.println("1. Create");
         System.out.println("2. Insert");
         System.out.println("3. Delete by name");
         System.out.println("4. Delete by E_id");
         System.out.println("5. Display");
         System.out.println("6. Exit");
         System.out.println("Enter your choice");
         var3 = var2.nextInt();
         switch (var3) {
            case 1:
               Create(var1);
               break;
            case 2:
               Insert(var1);
               break;
            case 3:
               deleteByEName(var1);
               break;
            case 4:
               deleteByEId(var1);
               break;
            case 5:
               display(var1);
               break;
            case 6:
               System.out.println("Exiting");
               break;
            default:
               System.out.println("Invalid choice");
         }
      } while(var3 != 6);

   }
}