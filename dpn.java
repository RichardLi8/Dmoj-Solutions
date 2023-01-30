import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long psa [] = new long [n+1];
        for(int i = 1; i <= n; i++) psa [i] = readInt() + psa [i-1];
        long dp [][] = new long [n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dp [i][j] = (long)1e18;
            }
        }
        for(int i = n; i >= 1; i--){
            dp [i][i] = 0;
            for(int j = i + 1; j <= n; j++){
                for(int k = i; k < j; k++){
                    dp [i][j] = Math.min(dp [i][j], dp [i][k] + dp [k+1][j] + psa [j]-psa[i-1]);
                }
            }
        }
        System.out.println(dp [1][n]);
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