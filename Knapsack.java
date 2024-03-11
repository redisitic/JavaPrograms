import java.util.*;

class Knapsack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] p;
        int[] w;

        System.out.print("Enter the value of n: ");
        int n = s.nextInt();

        System.out.print("Enter the capacity of knapsack: ");
        int capacity = s.nextInt();

        p = new int[n];
        w = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value of weight (W) for item " + (i + 1) + ": ");
            w[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the value of Profit (P) for item " + (i + 1) + ": ");
            p[i] = s.nextInt();
        }

        s.close();

        int[] piwi = ratio(p, w, n);
        double[] x = knapsack(capacity, w, piwi, n);

        double maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit += x[i] * p[i];
        }
        
        System.out.println("Maximum Profit: " + maxProfit);
    }

    static int[] ratio(int[] p, int[] w, int n) {
        int[] piwi = new int[n];
        for (int i = 0; i < n; i++) {
            piwi[i] = p[i] / w[i];
        }
        return piwi;
    }

    static double[] knapsack(int capacity, int[] w, int[] piwi, int n) {
        double[] x = new double[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
    
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (piwi[indices[j]] < piwi[indices[j + 1]]) {
                    int temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;
                }
            }
        }
    
        int currentWeight = 0;
    
        for (int i : indices) {
            if (w[i] <= capacity - currentWeight) {
                x[i] = 1;
                currentWeight += w[i];
            } else {
                x[i] = (capacity - currentWeight) / (double) w[i];
                break;
            }
        }
        return x;
    }
    
}