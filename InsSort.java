public class InsSort {
    public static void main(String[] args){
        int n = 200000;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random()*n*10);
        }
        double startTime = System.nanoTime();
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        double endTime   = System.nanoTime();
        double totalTime = (endTime - startTime)/1000000;
        System.out.println(totalTime);
    }
}
