import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(); int k = readInt(), m = (int)1e5, mod = (int)1e9+7;
        int candies [] = new int [n];
        for(int i = 0; i < n; i++) candies [i] = readInt();
        long dp [][] = new long [n][m+1], psa [][] = new long [n][m+2];
        for(int i = n-1; i >= 0; i--){
            if(i == n-1){
                for(int j = 0; j <= candies [i] && j <= k; j++){
                    dp [i][j] = 1;
                }
            }
            else{
                for(int j = 0; j <= k; j++){
                    dp [i][j] = psa [i+1][j+1] - psa [i+1][j-Math.min(j, candies [i])];
                    dp[i][j] %= mod;
                    dp[i][j] += mod;
                    dp[i][j] %= mod;
                }
            }
            for(int j = 0; j <= m; j++){
                psa [i][j+1] = dp [i][j] + psa [i][j];
                psa [i][j+1] %= mod;
            }
        }
        System.out.println(dp [0][k]);
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