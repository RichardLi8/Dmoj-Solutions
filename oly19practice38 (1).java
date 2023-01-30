import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static int [] dep;
    static int mod = 998244353, LOG;
    static int [][] anc;
    static int lca(int u, int v){
        if(dep [v] > dep [u]){
            int temp = u;
            u = v;
            v = temp;
        }
        for(int i = LOG-1; i >= 0; i--){
            if(dep [anc [u][i]] >= dep [v]){
                u = anc [u][i];
            }
        }
        if(u == v) return u;
        for(int i = LOG-1; i >= 0; i--){
            if(anc [u][i] != anc [v][i]){
                u = anc [u][i]; v = anc [v][i];
            }
        }
        return anc [u][0];
    }
    static void dfs(int src, int pre, int parent){
        dep [src] = pre+1;
        anc [src][0] = parent;
        for(int v : adj [src]){
            if(dep [v] == 0){
                dfs(v, dep [src], src);
            }
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(); LOG = 31-Integer.numberOfLeadingZeros(n)+1;
        adj = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < n-1; i++){
            int x = readInt(), y = readInt();
            adj [x].add(y);
            adj [y].add(x);
        }
        dep = new int [n+1]; anc = new int [n+1][LOG];
        dfs(1, 0, 0);
        for(int j = 1; j < LOG; j++){
            for(int i = 1; i <= n; i++){
                anc [i][j] = anc [anc[i][j-1]][j-1];
            }
        }
        long [][] psa = new long [n+1][51];
        for(int i = 0; i <= n; i++){
            psa [i][0] = i-1;
        }
        for(int j = 1; j <= 50; j++){
            for(int i = 1; i <= n; i++){
                psa [i][j] = (psa [i][j-1]-psa [i-1][j-1]) * (i-1);
                psa [i][j] = (psa [i][j] + psa [i-1][j])%mod;
            }
        }
        int q = readInt();
        for(int i = 0; i < q; i++){
            int u = readInt(), v = readInt(), k = readInt();
            int lca = lca(u, v);
            long ans = ((psa [dep [u]][k]-psa [dep [lca]-1][k] + psa [dep [v]][k]-psa [dep [lca]-1][k] - psa [dep[lca]][k] + psa [dep [lca]-1][k])%mod+mod)%mod;
            System.out.println(ans);
        }
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