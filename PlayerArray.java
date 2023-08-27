import java.util.*;
public class PlayerArray{
    public static void main(String args[]){
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter the Number of Players: ");
        int rows = sn.nextInt();
        System.out.println("");
        System.out.print("Enter the number of matches: ");
        int columns = sn.nextInt() + 1;
        
    float[][] PlayerArray = new float[rows][columns];
    for(int i = 0; i < rows; i++){
        System.out.println("Player "+ (i+1)+" ");
        System.out.println("");
        for(int j = 0; j < columns-1; j++){
            System.out.print("Enter the Score for match "+(j+1)+": ");
            float temp = sn.nextFloat();
            if(temp < 1 || temp > 150){
                System.out.println("The score is out of range.");
                System.exit(0);
            }
            PlayerArray[i][j] = temp;
        }
        }
    for(int i = 0; i < rows; i++){
        float tempsum = 0;
        for(int j = 0; j < columns; j++){
            if(j < (columns - 1)){
                tempsum = tempsum + PlayerArray[i][j];
            }
            else if(j == (columns - 1)){
                tempsum = tempsum / (columns -1);
                PlayerArray[i][j] = tempsum;
            }
        }
    }
    float[][] PlayerLeaderboard = new float[rows][2];
    for(int i = 0; i < rows; i++){
        PlayerLeaderboard[i][1] = i+1;
    }
    for(int i = 0; i < rows; i++){
        PlayerLeaderboard[i][0] = PlayerArray[i][columns - 1];
    }
    Arrays.sort(PlayerLeaderboard,new Comparator<float[]>(){
        public int compare(float[] a, float[] b){
            return Float.compare(b[0], a[0]);
        }
    });
    for(int i = 0; i < rows; i++){
        System.out.println("");
        System.out.print("Average score of Player "+ (PlayerLeaderboard[i][1]) + "'s Score: " + PlayerLeaderboard[i][0]);
    }
    sn.close();
    }
}