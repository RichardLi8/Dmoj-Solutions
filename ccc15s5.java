import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [][][][] dp;
    static int [] a, b;
    static int n;
    static int find(int pie, int can, int l, int r){
        if(dp [pie][can][l][r] != -1) return dp [pie][can][l][r];
        int ans = 0;
        if(pie <= n){
            if(can == 1) ans = Math.max(ans, a[pie] + find(pie+1, 0, l, r)); //take the one right now
            ans = Math.max(ans, find(pie+1, 1, l, r)); // dont take the one right now
        }
        if(l <= r){
            if(can == 0){//sacrifice a bad pie
                ans = Math.max(ans, find(pie, 1, l+1, r));
            }
            if(can == 1){//sacrifice the current pie for another
                ans = Math.max(ans, b [r] + find(pie, 0, l, r-1));
            }
        }
        return dp [pie][can][l][r] = ans;
    }
    public static void main(String[] args) throws IOException{
        n = readInt();
        a = new  int [n+1]; 
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
        }
        int m = readInt();
        b = new int [m+1];
        for(int i = 1; i <= m; i++){
            b [i] = readInt();
        }
        Arrays.sort(b, 1, m+1);
        dp = new int [n+2][2][m+2][m+2];
        for(int i = 1; i <= n+1; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k <= m+1; k++){
                    Arrays.fill(dp [i][j][k], -1);
                }
            }
        }
        System.out.println(find(1, 1, 1, m));
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(v == p.v) return Integer.compare(w, p.w);
            return Integer.compare(w, p.w);
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