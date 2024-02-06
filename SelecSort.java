public class SelecSort{
    public static void main(String[] args){
        int n = 500000;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random()*n*10);
        }
        double startTime = System.nanoTime();
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        double endTime   = System.nanoTime();
        double totalTime = (endTime - startTime)/1000000;
        System.out.println(totalTime);
    }
}