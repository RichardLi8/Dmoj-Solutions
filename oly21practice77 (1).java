import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), x = readInt(); long [][] dp = new long [2501][51];
        dp [0][0] = 1;
        for(int i = 0; i < n; i++){
            int a = readInt();
            for(int j = 2500; j >= a; j--){
                for(int k = 50; k >= 1; k--){
                    dp [j][k] += dp [j-a][k-1];
                }
            }
        }
        long ans = 0;
        for(int j = 1; j*x <= 2500 && j <= 50; j++){
            ans += dp [x*j][j];
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(x, p.x);
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