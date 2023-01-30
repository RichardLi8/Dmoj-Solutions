import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), c = readInt(), dp [] = new int [n+1];
        Arrays.fill(dp, (int)-1e9);
        dp [0] = 0;
        for(int i = 0; i < c; i++){
            int d = readInt();
            for(int j = d; j <= n; j++){
                if(dp [j] > 0 && dp [j-d]+1 > 0) dp [j] = Math.min(dp [j], dp[j-d]+1);
                else dp [j] = Math.max(dp [j], dp[j-d]+1);
            }
        }
        System.out.println(dp [n] > 0 ? "Roberta wins in " + dp [n] + " strokes." : "Roberta acknowledges defeat.");
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