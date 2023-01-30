import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        String s = next();
        String rev = new StringBuilder(s).reverse().toString();
        int dp [][] = new int [2][n+1];
        int index = 1;
        for(int i = 1; i <= n; i++){
            index ^= 1;
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp [index][j] = dp [1-index][j-1] + 1;
                }
                else{
                    dp [index][j] = Math.max(dp[1-index][j], dp [index][j-1]);
                }
            }
        }
        System.out.println((n-dp[index][n]));
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