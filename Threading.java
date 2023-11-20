class Square extends Thread {
    private int[] arr = new int[50];
    public Square(int[] arr){
        this.arr = arr;
    }
    public void run(){
        int x = 1;
        for(int i = 1; i <= 100; i = i + 2){
            arr[i - 1] = x * x;
            x++;
        }
    }
}
class Cube extends Thread{
    private int[] arr = new int[50];
    public Cube(int[] arr){
        this.arr = arr;
    }
    public void run(){
        int y = 1;
        for(int i = 2; i <= 100; i = i + 2){
            arr[i - 1] = y * y * y;
            y++;
        }
    }
}
public class Threading{
        public static void main(String Args[]){
        int[] arr = new int[100];
        Square s1 = new Square(arr);
        Cube c1 = new Cube(arr);
        s1.start();
        c1.start();
        try{
            s1.join();
            c1.join();
        } catch(Exception e){
            System.out.println(e);
        }
        for(int i = 0; i < 100; i++){
            System.out.println(arr[i]);
        }
    }
}