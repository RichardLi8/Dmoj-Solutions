import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        List <edge> routes [] = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) routes [i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), w = readInt();
            routes [x].add(new edge(y, w));
        }
        int [] dist1 = new int [n+1], dist2 = new int [n+1];
        Arrays.fill(dist1, (int)1e9); Arrays.fill(dist2, (int)1e9);
        dist1 [1] = 0;
        PriorityQueue <edge> q = new PriorityQueue();
        q.add(new edge(1, 0));
        while(!q.isEmpty()){
            int u = q.peek().v, d = q.poll().w;
            if(d > dist2 [u]) continue;
            for(edge e : routes [u]){
                int v = e.v, w = e.w;
                if(dist1 [v] > dist1 [u] + w){
                    dist2 [v] = dist1 [v];
                    dist1 [v] = dist1 [u]+w;
                    q.add(new edge(v, dist1[v]));
                }
                else if(dist1 [v] != dist1 [u] + w && dist2 [v] > dist1 [u] + w){
                    dist2 [v] = dist1 [u] + w;
                    q.add(new edge(v, dist2 [v]));
                }
                if (dist1[v] != dist2[u] + w && dist2[v] > dist2[u] + w) {
                    dist2[v] = dist2[u] + w;
                    q.add(new edge(v, dist2 [v]));
                }
            }
        }
        System.out.println(dist2 [n] != (int)1e9 ? dist2 [n]:-1);
    }
    static class edge implements Comparable <edge>{
        int v, w;
        public edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
        public int compareTo(edge x){
            return Integer.compare(w, x.w);
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