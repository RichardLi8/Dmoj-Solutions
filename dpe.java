import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), max = (int)10e5;
        long dp [] = new long [max+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp [0] = 0;
        for(int i = 0; i < n; i++){
            int w = readInt(), v = readInt();
            for(int j = max; j >= v; j--){
                dp [j] = Math.min(dp [j], dp [j-v] + w);
            }
        }
        for(int i = max; i >= 0; i--){
            if(dp [i] <= m) {
                System.out.println(i);
                return;
            }
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}