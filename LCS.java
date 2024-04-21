import java.util.*;
public class LCS {
    public static int longestCommonSubsequenceLength(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        Queue<Integer> Q = new LinkedList<>();
        int matchingNumber = 0;
        for(int i = 0; i <= n; i++){
            Queue<Integer> currentRow = new LinkedList<>();
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    currentRow.offer(0);
                } else{
                    if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                        int diag = Q.poll();
                        int previousValue = diag + 1;
                        currentRow.offer(previousValue);
                        if (previousValue > matchingNumber){
                            matchingNumber = previousValue;
                        }
                    } else{
                        int diag = Q.poll();
                        int verticalValue = currentRow.peek(); 
                        int previousValue = Math.max(diag, verticalValue);
                        currentRow.offer(previousValue);
                    }
                }
            }
            Q = currentRow;
        }
        return matchingNumber;
    }
    public static void main(String[] args) {
        String s1 = "helloiamstupid";
        String s2 = "iamnothello";
        int lcsLength = longestCommonSubsequenceLength(s1, s2);
        System.out.println(lcsLength); 
    }
}
