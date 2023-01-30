import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n ;
        while((n = readInt()) != 0){
            int [] nums = new int [n+1];
            for(int i = 1; i <= n; i++) nums [i] = readInt();
            int [][] dp = new int [n+1][n+1];
            for(int i = n-1; i >= 1; i--){
                for(int j = i+2; j <= n; j++){
                    for(int k = i + 1; k < j; k++){
                        dp [i][j] = Math.max(dp [i][j], dp [i][k] + nums [i] + nums [k] + nums [j] + dp [k][j]);
                    }
                }
            }
            System.out.println(dp [1][n]);
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