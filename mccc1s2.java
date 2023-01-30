import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        boolean [][] grid = new boolean [n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(readInt() == 1) grid [i][j] = true;
                else grid [i][j] = false;
            }
        }
        List <pair> output = new ArrayList();
        boolean goal = false;
        if(grid [0][0] != goal){
            output.add(new pair('R', 1));
            for(int j = 0; j < n; j++) grid [0][j] = !grid [0][j];
        }
        for(int i = 1; i < n; i++){
            if(grid [i][0] == goal){
                output.add(new pair('R', i+1));
                for(int j = 0; j < n; j++){
                    grid [i][j] = !grid [i][j];
                }
            }
        }
        for(int j = 1; j < n; j++){
            if(grid [0][j] == goal){
                output.add(new pair('C', j+1));
                for(int i = 0; i < n; i++){
                    grid [i][j] = !grid [i][j];
                }
            }
        }
        int cnt = 0;
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if(grid [i][j] == goal) cnt++;
            }
        }
        if(cnt != (n-1)*(n-1)){
            System.out.println(-1);
            return;
        }
        output.add(new pair('C', 1));
        output.add(new pair('R', 1));
        System.out.println(output.size());
        for(pair p : output){
            System.out.println(p.c + " " + p.x);
        }
    }
    static class pair{
        char c; int x;
        public pair(char c, int x){
            this.c = c;
            this.x = x;
        }
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
}