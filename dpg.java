import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static boolean [] visited;
    static int [] dp;
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        dp = new int [n+1]; visited = new boolean [n+1]; adj = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt();
            adj [x].add(y);
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(!visited [i]) dfs(i);
            ans = Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }
    static void dfs(int src){
        visited [src] = true;
        for(int v : adj [src]){
            if(!visited [v]) dfs(v);
            dp [src] = Math.max(dp [src], dp [v] + 1);
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