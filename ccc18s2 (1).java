import java.util.*;
/**
 *
 * @author richa
 */
public class Sunflowers {

    public static int [][] rotate(int [][] grid){
        int rotated [][] = new int [grid.length][grid.length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                rotated [i][grid.length-1-j] = grid[j][i];
            }
        }
        return rotated;
    }
    
    public static boolean check(int [][] grid){
        for(int i = 0; i < grid.length-1; i++){
            if(grid[i][0] > grid[i+1][0]){
                return false;
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length-1; j++){
                if(grid[i][j] > grid[i][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [][] grid = new int [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid [i][j] = input.nextInt();
            }
        }
        for(int i = 0; i < 4; i++){
            if(check(grid)){
                break;
            }
            else{
                grid = rotate(grid);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
}