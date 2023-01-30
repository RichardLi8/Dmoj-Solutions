import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <pair> adj [];
    static int [][] memo;
    static int n, m;
    public static int dfs(int src, int state){
        if(memo [src][state] != 0) return memo [src][state];
        if(src == n-1) return 0;
        for(pair p : adj [src]){
            int v = p.v, d = p.d;
            if((state & 1 << v) == 0){
                memo [src][state] = Math.max(memo [src][state], d + dfs(v, state | (1 << v)));
            }
        }
        return memo [src][state] == 0? Integer.MIN_VALUE : memo [src][state];
    }
    public static void main(String [] args) throws IOException{
        n = readInt(); m = readInt();
        adj = new ArrayList [n]; memo = new int [n][1 << n];
        for(int i = 0; i < n; i++) adj [i] = new ArrayList(); 
        for(int i = 0; i < m; i++){
            adj [readInt()].add(new pair(readInt(), readInt()));
        }
        System.out.println(dfs(0, 1));
    }
    static class pair{
        int v, d;
        public pair(int x, int y){
            v = x;
            d = y;
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