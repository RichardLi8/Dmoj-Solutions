import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        int [] w = new int [n+1];
        int [] v = new int [n+1];
        for(int i = 1; i <= n; i++){
            w [i] = readInt();
            v [i] = readInt();
        }
        long [][] dp = new long [n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(w [i] <= j){
                    dp [i][j] = Math.max(dp [i-1][j-w [i]] + v [i], dp [i-1][j]);
                }
                else dp [i][j] = dp [i-1][j];
            }
        }
        System.out.println(dp[n][m]);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}