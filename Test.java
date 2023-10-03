import java.util.*;
public class Test {
    public static void main(String Args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the page size(in bytes): "); //8 Bytes
        int pageSize = sc.nextInt();
        System.out.println(" ");
        System.out.print("Enter the cache size(in bytes): "); //128 Bytes
        int cacheSize = sc.nextInt();
        System.out.println(" ");
        System.out.print("Enter the main memory size(in kilobytes): "); //2 KiloBytes
        int memSize = sc.nextInt() * 1024;
        sc.close();
        int columnSize = cacheSize/pageSize;
        int[][] cache = new int[pageSize][(columnSize)];
        
        int x = 0;
        for(int j = 0; j < columnSize; j++){
            for(int i = 0; i < pageSize; i++){
                cache[i][j] = x+1;
                x++;
            }
        }
        
        for(int i = 0; i < pageSize; i++){
            System.out.println(" ");
            for(int j = 0; j < columnSize; j++){
                System.out.print(cache[i][j] + " ");
            }
        }
    }
}