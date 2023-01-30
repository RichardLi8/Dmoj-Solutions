import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String[] args) throws IOException{
        //w is the width of the board; h is the height of the board
        int w = readInt();
        int h = readInt();
        //cw is the cut out width of the board; ch is the cut out height of the board
        int cw = readInt();
        int ch = readInt();
        boolean taken [][] = new boolean [h+2][w+2];
        //add a border so no index out of bounds
        for(int i = 0; i <= w+1; i++){
            taken [0][i] = true;
            taken [h+1][i] = true;
        }
        for(int i = 0; i <= h; i++){
            taken [i][0] = true;
            taken [i][w+1] = true;
        }
        
        //marking the cut out tiles as true
        //top left
        for(int i = 1; i <= ch; i++){
            for(int j = 1; j <= cw; j++){
                taken [i][j] = true;
            }
        }
        //top right
        for(int i = 1; i <= ch; i++){
            for(int j = w; j > w-cw; j--){
                taken [i][j] = true;
            }
        }
        //bottom left
        for(int i = h; i > h-ch; i--){
            for(int j = 1; j <= cw; j++){
                taken [i][j] = true;
            }
        }
        //bottom right
        for(int i = h; i > h-ch; i--){
            for(int j = w; j > w-cw; j--){
                taken [i][j] = true;
            }
        }
        int steps = readInt();
        int x = cw+1;
        int y = 1;
        char direction = 'R';
        int count = 0;
        taken [y][x] = true;
        while(count < steps){
            int curr = count;
            if(direction == 'R'){
                if(!taken [y-1][x]){
                    y--;
                    taken [y][x] = true;
                    count++;
                    direction = 'U';
                }
                else if(!taken [y][x+1]){
                    x++;
                    taken [y][x] = true;
                    count++;
                }
                else if(!taken [y+1][x]){
                    y++;
                    taken [y][x] = true;
                    count++;
                    direction = 'D';
                }
            }
            else if(direction == 'L'){
                if(!taken [y+1][x]){
                    y++;
                    taken [y][x] = true;
                    count++;
                    direction = 'D';
                }
                else if(!taken [y][x-1]){
                    x--;
                    taken [y][x] = true;
                    count++;
                }
                else if(!taken [y-1][x]){
                    y--;
                    taken [y][x] = true;
                    count++;
                    direction = 'U';
                }
            }
            else if(direction == 'D'){
                if(!taken [y][x+1]){
                    x++;
                    taken [y][x] = true;
                    count++;
                    direction = 'R';
                }
                else if(!taken [y+1][x]){
                    y++;
                    taken [y][x] = true;
                    count++;
                }
                else if(!taken [y][x-1]){
                    x--;
                    taken [y][x] = true;
                    count++;
                    direction = 'L';
                }
            }
            else if(direction == 'U'){
                if(!taken [y][x-1]){
                    x--;
                    taken [y][x] = true;
                    count++;
                    direction = 'L';
                }
                else if(!taken [y-1][x]){
                    y--;
                    taken [y][x] = true;
                    count++;
                }
                else if(!taken [y][x+1]){
                    x++;
                    taken [y][x] = true;
                    count++;
                    direction = 'R';
                }
            }
            if(curr == count) break;
        }
        System.out.println(x);
        System.out.println(y);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
            return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
            return Long.parseLong(next());
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