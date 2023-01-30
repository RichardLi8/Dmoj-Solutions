import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [][] dp = new int [n][n];
        for(int i = 0; i < n; i++){
            String s = next();
            for(int j = 0; j < n; j++){
                if(s.charAt(j) == '#') dp [i][j] = 1;
            }
        }
        for(int i = n-2; i >= 0; i--){
            for(int j = 1; j < n-1; j++){
                if(dp[i][j] == 0) continue;
                dp [i][j] += Math.min(Math.min(dp [i+1][j], dp[i+1][j-1]), dp [i+1][j+1]);            }
        }        
        long ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans += dp [i][j];
           }
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