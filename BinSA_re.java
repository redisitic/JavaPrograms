import java.util.*;
public class BinSA_re{
    public static int binSearch(int[] nums, int searchTarget, int left, int right){
        if(right >= left && left <= nums.length - 1){
            int median = ((left + right)/2) + 1;
            System.out.println(median + " " + nums[median]);
            int tempN = nums[median];
            if(tempN == searchTarget){   
                return median;
            }else if(tempN > searchTarget){
                binSearch(nums, searchTarget, left, (median - 1));
            }else if(tempN < searchTarget){
                binSearch(nums, searchTarget, (median + 1), right);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums =  new int[]{1,3,5,7,9,11,13,15,17,19};
        int len = nums.length;
        System.out.print("Enter the number to be searched: ");
        Scanner sc = new Scanner(System.in);
            int searchTarget = sc.nextInt();
        sc.close();
        int targetIndex = binSearch(nums, searchTarget, 0, (len - 1));
        if(targetIndex == -1){
            System.out.println("The element "+ searchTarget +" is not present in the array");
        }else{
            System.out.println("The index of "+ searchTarget +" in the array is: "+ (targetIndex + 1) +".");
        }
    }
}
