import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static int [] parent;
    static long [] treasure;
    static void union(int u, int v){
        treasure [parent [v]] += treasure [parent [u]];
        parent [u] = parent [v];
    }
    static int find(int v){
        if(parent [v] != v) parent [v] = find(parent [v]);
        return parent [v];
    }
    public static void main(String[] args) throws IOException {
        int n = readInt();
        treasure = new long [n+1]; parent = new int [n+1]; adj = new ArrayList [n+1];
        for(int i = 1; i <= n; i++){
            treasure [i] = readInt();
            parent [i] = i;
            adj [i] = new ArrayList();
        }
        ArrayList <pair> edges = new ArrayList();
        for(int i = 0; i < n-1; i++){
            int x = readInt(), y = readInt(), t = readInt();
            if(t >= 2){
                union(find(x), find (y));
            }
            else{
                edges.add(new pair(x, y));
            }
        }
        for(int i = 0; i < edges.size(); i++){
            int u = edges.get(i).u, v = edges.get(i).v;
            u = find(u); v = find(v);
            adj [u].add(v);
            adj [v].add(u);
        }
        System.out.println(dfs(new boolean [n+1], find(1)));
    }
    static long dfs(boolean visited [], int src){
        visited [src] = true;
        long ans = treasure [src];
        long cur = 0;
        for(Integer v : adj [src]){
            if(!visited [v]){
                cur = Math.max(cur, dfs(visited, v));
            }
        }
        return ans + cur;
    }
    static class pair{
        int u, v;
        public pair(int a, int b){
            u = a;
            v = b;
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