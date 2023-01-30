import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        long [] dp = new long [m+1];
        for(int i = 0; i < n; i++){
            int w = readInt(), v = readInt();
            for(int j = m; j >= w; j--){
                dp [j] = Math.max(dp [j-w]+v, dp [j]);
            }
        }
        System.out.println(dp [m]);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}