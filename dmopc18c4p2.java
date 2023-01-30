import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int value [] = new int [n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            value [i] = readInt();
            sum += value [i];
        }
        int [] dp = new int [sum+1];
        Arrays.fill(dp, (int)1e9);
        dp [0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = sum; j >= value [i]; j--){
                dp [j] = Math.min(dp [j], dp[j-value[i]]+value[i]);
            }
        }
        int ans = (int)1e9;
        for(int i = 0; i <= sum; i++){
            ans = Math.min(Math.abs(sum-dp[i]-dp[i]), ans);
        }
        System.out.println(ans);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}