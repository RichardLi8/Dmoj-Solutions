import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int mod = (int)1e6;
        for(int q = 0; q < 5; q++){
            int n = readInt();
            if((n * 3) % 2 == 0){
                int dp [] = new int [n+1];
                dp [0] = 1;
                for(int i = 2; i <= n; i+=2){
                    dp [i] += 3 * dp [i-2];
                    for(int j = i-4; j >= 0; j-=2){
                        dp [i] += dp[j]*2;
                    }
                    dp [i] %= mod;
                }
                System.out.println(dp [n]);
            }
            else System.out.println(0);
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