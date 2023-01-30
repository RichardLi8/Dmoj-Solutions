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
        boolean [] dp = new boolean [sum+1];
        dp [0] = true;
        for(int i = 0; i < n; i++){
            for(int j = sum; j >= value [i]; j--){
                dp [j] = dp[j-value[i]] || dp [j];
            }
        }
        int ans = (int)1e9;
        for(int i = 0; i <= sum; i++){
            if(dp [i]) ans = Math.min(Math.abs(sum-i-i), ans);
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