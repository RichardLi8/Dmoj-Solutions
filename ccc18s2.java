import java.util.Scanner;
/**
 *
 * @author richa
 */
public class Sunflowers {

    public static boolean isCorrect(int arr[][], int n){
        boolean correct = true;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                if(!(arr[j][i] < arr[j+1][i+1])){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int[][] rotate(int arr [][], int n){
        int newArr [][] = new int [n][n];
        int pos1 = 0;
        int pos2 = n-1;
        while(pos1 < n){
            for(int i = 0; i < n; i++){
                newArr[pos2][i] = arr[i][pos1];
            }
            pos1++;
            pos2--;
        }
        return newArr;
    }
    
    public static void print(int arr[][], int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int plants1 [][] = new int [n][n];
        int plants2 [][] = new int [n][n];
        int plants3 [][] = new int [n][n];
        int plants4 [][] = new int [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                plants1 [i][j] = input.nextInt();
            }
        }
        if(isCorrect(plants1, n)){
            print(plants1, n);
        }
        else{
            plants2 = rotate(plants1, n);
            if(isCorrect(plants2, n)){
                print(plants2, n);
            }
            else{
                plants3 = rotate(plants2, n);
                if(isCorrect(plants3, n)){
                    print(plants3, n);
                }
                else{
                    print(rotate(plants3, n), n);
                }
            }
        }
    }
    
}