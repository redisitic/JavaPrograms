import java.util.*;
public class BinSA_it{
    public static int binSearch(int[] nums, int searchTarget){
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int median = (left + right)/2;
            if(nums[median] == searchTarget){
                return median;
            }else if(nums[median] < searchTarget){
                left = median + 1;
            }else{
                right = median - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums =  new int[]{1,3,5,7,9,11,13,15,17,19,21};
        System.out.print("Enter the number to be searched: ");
        Scanner sc = new Scanner(System.in);
            int searchTarget = sc.nextInt();
        sc.close();
        int targetIndex = binSearch(nums, searchTarget);
        if(targetIndex == -1){
            System.out.println("The element "+ searchTarget +" is not present in the array");
        }else{
            System.out.println("The index of "+ searchTarget +" in the array is: "+ (targetIndex + 1) +".");
        }
    }
}