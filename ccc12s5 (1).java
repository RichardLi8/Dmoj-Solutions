import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int h = readInt(), w = readInt();
        int [][] grid = new int [h+1][w+1];
        boolean [][] cat = new boolean [h+1][w+1];
        int n = readInt();
        for(int i = 0; i < n; i++){
            cat [readInt()][readInt()] = true;
        }
        grid [1][1] = 1;
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= w; j++){
                if(cat [i][j]) continue;
                grid [i][j] += grid [i-1][j] + grid [i][j-1];
            }
        }
        System.out.println(grid [h][w]);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}