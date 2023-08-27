import java.util.Scanner;
public class StudentArray{
    public static void main(String args[]){
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter the Number of students: ");
        int rows = sn.nextInt();
        System.out.println("");
        System.out.print("Enter the number of semesters: ");
        int columns = sn.nextInt() + 1;
        
    float[][] studentArray = new float[rows][columns];
    for(int i = 0; i < rows; i++){
        System.out.println("Student "+ (i+1)+" ");
        System.out.println("");
        for(int j = 0; j < columns-1; j++){
            System.out.print("Enter the grade for semester "+(j+1)+": ");
            float temp = sn.nextFloat();
            studentArray[i][j] = temp;
        }
        }
    for(int i = 0; i < rows; i++){
        float tempsum = 0;
        for(int j = 0; j < columns; j++){
            if(j < (columns - 1)){
                tempsum = tempsum + studentArray[i][j];
            }
            else if(j == (columns - 1)){
                tempsum = tempsum / (columns -1);
                studentArray[i][j] = tempsum;
            }
        }
    }
    for(int i = 0; i < rows; i++){
        System.out.println("");
        System.out.print("Average of Student "+ (i+1) + "'s marks: " + studentArray[i][columns - 1]);
    }
    sn.close();
    }
}