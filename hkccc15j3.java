import java.util.*;
/**
 *
 * @author richa
 */
public class QueensCantAttackMe {
    
    public static void diagonal(boolean [][] board, int x, int y){
        for(int i = 0; x + i < board.length && y - i >= 0; i++){
            board [x+i][y-i] = true;
        }
        for(int i = 1; x - i >= 0 && y + i < board.length; i++){
            board [x-i][y+i] = true;
        }
        for(int i = 1; x + i < board.length && y + i < board.length; i++){
            board [x+i][y+i] = true;
        }
        for(int i = 1; x - i >= 0 && y - i >= 0; i++){
            board [x-i][y-i] = true;
        }
    }
    
    public static void cross(boolean [][] board, int x, int y){
        for(int i = 0; i < board.length; i++){
            board [i][y] = true;
            board [x][i] = true;
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        boolean board [][] = new boolean [n][n];
        for(int  i = 0; i < m; i++){
            int x = input.nextInt()-1;
            int y = input.nextInt()-1;
            diagonal(board, x, y);
            cross(board, x, y);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!board [i][j]) count++;
            }
        }
        System.out.println(count);
    }
    
}