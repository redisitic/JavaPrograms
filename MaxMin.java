public class MaxMin{
    static class MaxMinResult {
        int max;
        int min;

        public MaxMinResult(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
    static MaxMinResult maxMin(int[] arr, int i, int j) {
        if (i == j) {
            return new MaxMinResult(arr[i], arr[i]);
        } else if (i == j - 1) {
            if (arr[i] < arr[j]) {
                return new MaxMinResult(arr[j], arr[i]);
            } else {
                return new MaxMinResult(arr[i], arr[j]);
            }
        } else {
            int mid = (i + j) / 2;
            MaxMinResult leftResult = maxMin(arr, i, mid);
            MaxMinResult rightResult = maxMin(arr, mid + 1, j);
            int max = Math.max(leftResult.max, rightResult.max);
            int min = Math.min(leftResult.min, rightResult.min);
            return new MaxMinResult(max, min);
        }
    }
    public static void main(String[] args){
        int arrLen = 1000;
        int[] glArr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            glArr[i] = (int) (Math.random() * arrLen * 10);
        }
        //int[] testArr = {20, 23, 19, 4, 34, 99}; //debug
        //MaxMinResult result = maxMin(testArr, 0, testArr.length - 1); //debug
        long inTime = System.nanoTime();
        MaxMinResult result = maxMin(glArr, 0, arrLen - 1);
        long enTime = System.nanoTime();
        double toTime = (double) (enTime - inTime) / 1000000;

        System.out.println("Max value: " + result.max);
        System.out.println("Min value: " + result.min);
        System.out.println(toTime + "ms");
    }
}