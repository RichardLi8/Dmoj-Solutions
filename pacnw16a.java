import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        String s = next();
        int dp [] = new int [s.length()];
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < i; j++){
                if(s.charAt(i) > s.charAt(j)) dp [i] = Math.max(dp [i], dp [j] + 1);
            }
            ans = Math.max(ans, dp [i] + 1);
        }
        System.out.println(26-ans);
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