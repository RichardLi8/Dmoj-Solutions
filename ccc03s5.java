import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int m = readInt();
        int d = readInt();
        List <edge> roads [] = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) roads [i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), w = readInt();
            roads [x].add(new edge(y, w));
            roads [y].add(new edge(x, w));
        }
        int [] dest = new int [d];
        for(int i = 0; i < d; i++) dest [i] = readInt();
        int dist [] = dij(roads);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < d; i++){
            ans = Math.min(dist [dest[i]], ans);
        }
        System.out.println(ans);
    }
    static int [] dij(List <edge> roads []){
        PriorityQueue <edge> q = new PriorityQueue();
        int dist [] = new int [roads.length];
        dist [1] = Integer.MAX_VALUE;
        q.add(new edge(1, Integer.MAX_VALUE));
        while(!q.isEmpty()){
            int u = q.peek().v, d = q.poll().w;
            if(d < dist [u]) continue;
            for(edge e : roads [u]){
                int v = e.v, w = e.w;
                if(dist [v] < Math.min(dist [u], w)){
                    dist [v] = Math.min(dist [u], w);
                    q.add(new edge(v, dist [v]));
                }
            }
        }
        return dist;
    }
    static class edge implements Comparable <edge>{
        int v, w;
        public edge(int v, int w){
            this.v = v;
            this.w = w;
        }
        public int compareTo(edge x){
            return -Integer.compare(w, x.w);
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
}