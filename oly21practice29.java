import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int t = readInt();
        for(int q = 0; q < t; q++){
            int n = readInt();
            int [] dp = new int [25001];
            Arrays.fill(dp, -1);
            dp [0] = 0;
            for(int i = 0; i < n; i++) {
                int v = readInt();
                for(int j = v; j <= 25000; j++){
                   if(dp [j-v] != -1){ 
                        dp [j] = Math.max(dp [j-v] + 1, dp [j]);
                   }
                }
            }
            int ans = 0;
            for(int i = 0; i <= 25000; i++){
                if(dp [i] == 1) ans++;
            }
            System.out.println(ans);
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