import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] parent;
    static void union(int x, int y){
        parent[find(x)] = parent[find(y)];
    }
    static int find(int x){
        if(parent [x] != x) parent [x] = find (parent[x]);
        return parent [x];
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        int [] f = new int [n+1]; parent = new int [n+1];
        for(int i = 1; i <= n; i++){
            f [i] = readInt();
            parent [i] = i;
        }
        for(int i = 0; i < m; i++){
            union(readInt(), readInt());
        }
        long ans = 0;
        edge [] edges = new edge [n-1];
        for(int i = 1; i <= n-1; i++){
            edges [i-1] = new edge(i, i+1, f[i+1]-f[i]);
        }
        Arrays.sort(edges);
        for(int i = 0; i < n-1; i++){
            edge e = edges [i];
            int u = e.u, v = e.v, d = e.d;
            if(find(u) != find(v)){
                union(u, v);
                ans+=d;
            }
        }
        System.out.println(ans);
    }
    static class edge implements Comparable <edge>{
        int u, v, d;
        public edge(int a, int b, int c){
            u = a;
            v = b;
            d = c;
        }
        public int compareTo(edge e){
            return Integer.compare(d, e.d);
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