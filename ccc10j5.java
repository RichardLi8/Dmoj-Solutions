import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class HelloWorld {
    
    public static void copy(boolean board [][], boolean fromLast [][]){
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                fromLast[i][j] = board[i][j];
            }
        }
    }
    
    public static void find(boolean board[][], int x, int y){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(Math.abs(i-x)+Math.abs(j-y) ==3 && (i != x && j != y)){
                    board[i][j] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        int startx = readInt()-1;
        int starty = readInt()-1;
        int endx = readInt()-1;
        int endy = readInt()-1;
        boolean [][] board = new boolean [8][8];
        board [endx][endy] = true;
        boolean found = false;
        int count = 1;
        if(endx == startx && endy == starty){
            System.out.println("0");
            found = true;
        }
        while(!found){
            boolean fromLast [][] = new boolean [8][8];
            copy(board, fromLast);
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(fromLast[i][j]){
                        find(board, i, j);
                    }
                }
            }
            if(board[startx][starty]){
                System.out.println(count);
                break;
            }
            count++;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
            return Long.parseLong(next());
    }
    static int readInt () throws IOException {
            return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
            return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
            return next().charAt(0);
    }
    static String readLine () throws IOException {
            return br.readLine().trim();
    }
}