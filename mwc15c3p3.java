import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean dfs(int x, int y, int c){
        if(c == s.length()-1) return true;
        vis [x][y] = true;
        boolean ans = false;
        for(int i = 0; i < 8; i++){
            int newx = x+dr[i], newy = y+dc[i];
            if(grid [newx][newy] == s.charAt(c+1) && !vis [newx][newy]){
                ans |= dfs(newx, newy, c+1);
            }
        }
        vis [x][y] = false;
        return ans;
    }
    static boolean vis [][];
    static char [][] grid;
    static int dr [] = {1, 1, 0, -1, -1, -1, 0, 1}, dc [] = {0, 1, 1, 1, 0, -1, -1, -1};
    static String s;
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        grid = new char [n+2][n+2]; vis = new boolean [n+2][n+2];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                grid [i][j] = next().charAt(0);
            }
        }
        for(int a = 0; a < q; a++){
            s = br.readLine();
            boolean ans = false;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(grid [i][j] == s.charAt(0)){
                        ans |= dfs(i, j, 0);
                    }
                }
            }
            System.out.println(ans? "good puzzle!" : "bad puzzle!");
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) { 
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}