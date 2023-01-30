import java.io.*;
import java.util.*;
public class HelloWorld {
    static void solve() throws IOException{
        int n = readInt(), m = readInt();
        int [][] dp = new int [n+1][m+1];
        dp [0][0] = 1;
        for(int i = 1; i <= n; i++){
            int l = readInt(), r = readInt();
            for(int k = l; k <= r; k++){
                for(int j = m; j >= k; j--){
                    dp [i][j] = (dp [i][j] + dp [i-1][j-k])%(int)1e9;
                }
            }
        }
        System.out.println(dp [n][m]);
    }
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int i = 0; i < t; i++) solve();
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}