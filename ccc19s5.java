import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int [][] a = new int [n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                a [i][j] = readInt();
            }
        }
        int cur = 1;
        for(int nxt = 2; nxt <= k; cur = nxt, nxt = (int)(1.5*cur)){
            int d = nxt-cur;
            for(int i = 1; i <= n-nxt+1; i++){
                for(int j = 1; j <= i; j++){
                    a [i][j] = Math.max(a [i][j], Math.max(a [i+d][j], a [i+d][j+d]));
                }
            }
        }
        int d = k-cur; long ans = 0;
        for(int i = 1; i <= n-k+1; i++){
            for(int j = 1; j <= i; j++){
                ans += Math.max(a [i][j], Math.max(a [i+d][j], a [i+d][j+d]));
            }
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
}