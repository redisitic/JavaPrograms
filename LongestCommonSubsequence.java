import java.util.Scanner;

public class LongestCommonSubsequence {

    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        return lcsUtil(X, Y, m, n);
    }

    // Function to find LCS of two strings
    private static int lcsUtil(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + lcsUtil(X, Y, m - 1, n - 1);
        } else {
            return Math.max(lcsUtil(X, Y, m, n - 1), lcsUtil(X, Y, m - 1, n));
        }
    }

    public static long measureExecutionTime(String X, String Y) {
        long startTime = System.nanoTime();
        lcs(X, Y);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static String longestCommonSubsequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // Building the dp array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Building the longest common subsequence
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.insert(0, X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input for the first test case
        System.out.println("Enter the first string:");
        String X1 = scanner.nextLine();

        System.out.println("Enter the second string:");
        String Y1 = scanner.nextLine();

        long timeTaken1 = measureExecutionTime(X1, Y1);
        System.out.println("Time taken for the first test case: " + timeTaken1 + " nanoseconds");
        System.out.println("Longest common subsequence for the first test case: " + longestCommonSubsequence(X1, Y1));
        
        // Take input for the second test case
        System.out.println("Enter the first string for the second test case:");
        String X2 = scanner.nextLine();

        System.out.println("Enter the second string for the second test case:");
        String Y2 = scanner.nextLine();

        long timeTaken2 = measureExecutionTime(X2, Y2);
        System.out.println("Time taken for the second test case: " + timeTaken2 + " nanoseconds");
        System.out.println("Longest common subsequence for the second test case: " + longestCommonSubsequence(X2, Y2));

        scanner.close();
    }
}
