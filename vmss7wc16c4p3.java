import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String [] args) throws IOException{
        int D = readInt(), I = readInt(), R = readInt();
        
        char [] one = (" " + next()).toCharArray(), two = (" " + next()).toCharArray();
        int n = one.length-1, m = two.length-1;
        int dp [][] = new int [n+1][m+1];
        for(int i = 1; i <= n; i++){
            dp [i][0] = D*i;
        }
        for(int j = 1; j <= m; j++){
            dp [0][j] = I*j;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(one [i] == two [j]) {
                    dp [i][j] = dp [i-1][j-1];
                }
                else {
                    dp [i][j] = Math.min(dp [i-1][j-1] + R, Math.min(dp [i][j-1] + I, dp [i-1][j] + D));
                }
            }
        }
        System.out.println(dp [n][m]);
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