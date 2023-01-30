import java.io.*;
import java.util.*;
public class HelloWorld {
    static int LCA(int u, int v) {
        if(dep[u] < dep[v]){
            int temp = u;
            u = v;
            v = temp;
        }
        for(int i=LOG-1; i>=0; i--) {
            if (dep[anc[u][i]] >= dep[v]) u = anc[u][i]; 
        }
        if(u == v)  return u;
        for(int i=LOG-1; i>=0; i--) {
            if (anc[u][i] != anc[v][i]) {u = anc[u][i]; v = anc[v][i];}
        }
        return anc[u][0];
    }
    static int [][] anc;
    static int LOG;
    static List <pair> adj [];
    static int [] dep; static long [] dist;
    static void dfs(int src, int w, int parent){
        dep [src] = dep [parent] + 1;
        dist [src] = dist [parent] + w;
        anc [src][0] = parent;
        for(pair p : adj [src]){
            if(dep [p.v] == 0) dfs(p.v, p.w, src);
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(); LOG = (int) (Math.log(n)/Math.log(2))+1;
        adj = new ArrayList [n+1]; dep = new int [n+1]; dist = new long [n+1];
        for(int i = 1; i <= n; i++){
            adj [i] = new ArrayList();
        }
        for(int i = 0; i < n-1; i++){
            int x = readInt()+1, y = readInt()+1, w = readInt();
            adj [x].add(new pair(y, w));
            adj [y].add(new pair(x, w));
        }
        anc = new int [n+1][LOG];
        dfs(1, 0, 0);
        for(int j = 1; j < LOG; j++){
            for(int i = 1; i <= n; i++){
                anc [i][j] = anc[anc [i][j-1]][j-1]; 
            }
        }
        int q = readInt();
        for(int i = 0; i < q; i++){
            int x = readInt()+1, y = readInt()+1;
            int lca = LCA(x, y);
            System.out.println(dist [x] + dist [y] - 2*dist [lca]);
        }
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
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
}