import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int mod = (int)1e9 + 7;
        int dp [] = new int [n+1];
        Arrays.fill(dp, 1);
        for(int i = 2; i < n; i*=2){
            for(int j = i; j <= n; j++){
                dp [j] += dp [j-i];
                dp [j] %= mod;
            }
        }
        System.out.println(dp [n]);
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