import java.util.*;

public class MatrixChain {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of matrices: ");
        int n = s.nextInt();

        int[] rows = new int[n];
        int[] columns = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the number of rows for matrix " + (i + 1) + ": ");
            rows[i] = s.nextInt();
            System.out.print("Enter the number of columns for matrix " + (i + 1) + ": ");
            columns[i] = s.nextInt();
        }

        System.out.println("\n");
        for(int i = 0; i < n; i++){
            System.out.println("The size of matrix " + i + " is: " + rows[i] + " * " + columns[i]);
        }
        System.out.println("\nMinimum number of multiplications is: " + matrixChain(rows, columns, n));
    }

    static int matrixChain(int rows[], int columns[], int n) {
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = j + i;
                dp[j][k] = Integer.MAX_VALUE;

                for (int x = j; x < k; x++) {
                    int count = dp[j][x] + dp[x + 1][k] + rows[j] * columns[x] * columns[k];
                    if (count < dp[j][k]) {
                        dp[j][k] = count;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
