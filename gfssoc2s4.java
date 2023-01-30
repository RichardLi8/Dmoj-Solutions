import java.io.*;
import java.util.*;
public class HelloWorld {
    static void dij(int src, int [] dist, List <pair> adj []){
        dist [src] = 0;
        PriorityQueue <pair> pq = new PriorityQueue();
        pq.add(new pair(src, 0));
        while(!pq.isEmpty()){
            int u = pq.peek().v, d = pq.poll().w;
            if(dist [u] < d) continue;
            for(pair p : adj [u]){
                int v = p.v, w = p.w;
                if(dist [v] > dist [u] + w){
                    dist [v] = dist [u] + w;
                    pq.add(new pair(v, dist [v]));
                }
            }
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        List <pair> [] adj = new ArrayList [n+1], radj = new ArrayList [n+1];
        int [] dist = new int [n+1], rdist = new int [n+1];
        for(int i = 1; i <= n; i++){
            adj [i] = new ArrayList(); radj [i] = new ArrayList();
            dist [i] = Integer.MAX_VALUE; rdist [i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), w = readInt();
            adj [x].add(new pair(y, w));
            radj [y].add(new pair(x, w));
        }
        dij(1, dist, adj); dij(n, rdist, radj);
        int g = readInt();
        int ans = dist [n];
        for(int i = 0; i < g; i++){
            int x = readInt(), y = readInt(), w = readInt();
            if(dist [x] == Integer.MAX_VALUE || rdist [y] == Integer.MAX_VALUE) continue;
            ans = Math.min(ans, dist [x] + w + rdist [y]);
        }
        System.out.println(ans != Integer.MAX_VALUE? ans : -1);
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