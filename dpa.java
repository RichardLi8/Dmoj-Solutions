import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int [] stones = new int [n];
        int [] dp = new int [n];
        for(int i = 0; i < n; i++) stones [i] = readInt();
        dp [1] = Math.abs(stones [0]-stones [1]);
        for(int i = 2; i < n; i++){
            int x = dp [i-1] + Math.abs(stones [i-1]-stones [i]);
            int y = dp [i-2] + Math.abs(stones [i-2]-stones [i]);
            dp [i] = Math.min(x, y);
        }
        System.out.println(dp [n-1]);
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