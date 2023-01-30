import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static boolean [] visited;
    static int [] dp;
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] nums = new int [n+1];
        long [] psa = new long [n+1];
        for(int i = 1; i <= n; i++){
            nums [i] = readInt();
            psa [i] = nums [i] + psa [i-1];
        }
        long dp [][] = new long [n+1][n+1];
        for(int i = n; i > 0; i--){
            dp [i][i] = nums [i];
            for(int j = i+1; j <= n; j++){
                if(i+1 == j){
                    dp [i][j] = Math.max(nums [i], nums [j]);
                }
                else{
                    long sum1 = psa [j-1]-psa [i-1];
                    long sum2 = psa [j]-psa [i];
                    dp [i][j] = Math.max(sum1-dp [i][j-1] + nums [j], nums [i] + sum2-dp[i+1][j]);
                    
                }
            }
        }
        System.out.println(dp [1][n]-(psa [n]-psa [0]-dp [1][n]));
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