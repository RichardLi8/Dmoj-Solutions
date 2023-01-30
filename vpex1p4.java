import java.io.*;
import java.util.*;
public class HelloWorld {
    static int lca(int u, int v){
        if(dep [v] > dep [u]){
            int temp = v;
            v = u;
            u = temp;
        }
        for(int i = LOG; i >= 0; i--){
            if(dep [anc [u][i]] >= dep [v]){
                u = anc [u][i];
            }
        }
        if(u == v) return u;
        for(int i = LOG; i >= 0; i--){
            if(anc [u][i] != anc [v][i]){
                u = anc [u][i]; v = anc [v][i];
            }
        }
        return anc [u][0];
    }
    static int LOG;
    static int [][] anc;
    static List <pair> adj [];
    static int [] dep; static long [] dist;
    static void dfs(int src){
        for(pair p : adj [src]){
            if(dep [p.x] == 0){
                dist [p.x] = dist [src] + p.y;
                dep [p.x] = dep [src]+1;
                anc [p.x][0] = src;
                dfs(p.x);
            }
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), d = readInt(); LOG = 31-Integer.numberOfLeadingZeros(n);
        adj = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < n-1; i++){
            int x = readInt(), y = readInt(), c = readInt();
            adj [x].add(new pair(y, c));
            adj [y].add(new pair(x, c));
        }
        dist = new long [n+1]; dep = new int [n+1]; anc = new int [n+1][LOG+1];
        dep [1] = 1; dfs(1); 
        for(int j = 1; j <= LOG; j++){
            for(int i = 1; i <= n; i++){
                anc [i][j] = anc [anc [i][j-1]][j-1];
            }
        }
        long [][] dp = new long [d+1][2];
        int [][] pre = new int [d+1][2]; pre [0][0] = 1; pre [0][1] = 1;
        for(int i = 1; i <= d; i++){
            pre [i][0] = readInt(); pre [i][1] = readInt();
            int lca = lca(pre [i][0], pre [i][1]);
            long travel = dist [pre [i][0]] + dist [pre [i][1]] - 2*dist [lca];
            int lca1 = lca(pre [i-1][0], pre [i][0]);
            int lca2 = lca(pre [i-1][1], pre [i][0]);
            dp [i][1] = Math.min(dist [pre [i-1][0]]+dist [pre [i][0]]-2*dist [lca1] + travel + dp [i-1][0], dist [pre [i-1][1]]+dist [pre [i][0]]-2*dist [lca2] + travel + dp [i-1][1]);
            lca1 = lca(pre [i-1][0], pre [i][1]);
            lca2 = lca(pre [i-1][1], pre [i][1]);
            dp [i][0] = Math.min(dist [pre [i-1][0]]+dist [pre [i][1]]-2*dist [lca1] + travel + dp [i-1][0], dist [pre [i-1][1]]+dist [pre [i][1]]-2*dist [lca2] + travel + dp [i-1][1]);
        }
        System.out.println(Math.min(dp [d][0], dp [d][1]));
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