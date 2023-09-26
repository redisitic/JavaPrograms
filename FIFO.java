import java.util.*;

public class FIFO{
    public static void main(String Args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the No of elements to be inserted: ");
        int noDigs = sc.nextInt();
        int[] digs = new int[noDigs];
        for(int i = 0; i < noDigs; i++){
            System.out.print("Enter the element: ");
            digs[i] = sc.nextInt();
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.print("Enter the legnth of cache: ");
        int pageSize = sc.nextInt();
        sc.close();

        int[] fifo = new int[pageSize];

        for(int i = 0; i < pageSize; i++){
            fifo[i] = 0;
        }

        int hits = 0;
        int pageNo = 0;
        boolean flag = false;

        for(int i = 0; i < noDigs; i++){
            if(pageNo == pageSize){
                pageNo = 0;
            }
            for(int j = 0; j < pageSize; j++){
                if(fifo[j] == digs[i]){
                    flag = true;
                    for(int k = 0; k < pageSize; k++){
                        System.out.print(" |" + fifo[k] + "| ");
                    }
                    System.out.print(" Hit ");
                    System.out.println(" ");
                }
            }
            if(flag == false){
                fifo[pageNo] = digs[i];
                pageNo++;
            }else if(flag == true){
                hits++;
                flag = false;
                continue;
            }
            for(int j = 0; j < pageSize; j++){
                System.out.print(" |" + fifo[j] + "| ");
            }
            System.out.println(" ");
        }
        System.out.println("Hits: " + hits);
    }
}
