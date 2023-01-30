import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <edge> adj [];
    static int dist [][];
    static void dij(int src){
        PriorityQueue <edge> pq = new PriorityQueue();
        dist [src][0] = 0;
        pq.add(new edge(src, 0, 0));
        while(!pq.isEmpty()){
            edge e = pq.poll();
            int u = e.v, t = e.t, h = e.h;
            if(t > dist [u][h]) continue;
            for(edge p : adj [u]){
                int v = p.v, t2 = p.t, h2 = p.h;
                if(h + h2 >= k) continue;
                if(dist [v][h + h2] > dist [u][h] + t2){
                    dist [v][h + h2] = dist [u][h] + t2;
                    pq.add(new edge(v, dist [v][h + h2], h + h2));
                }
            }
        }
    }
    static int k;
    public static void main(String [] args) throws IOException{
        k = readInt(); int n = readInt(), m = readInt();
        adj = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), t = readInt(), h = readInt(); 
            adj [x].add(new edge(y, t, h));
            adj [y].add(new edge(x, t, h));
        }
        dist = new int [n+1][k];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < k; j++){
                dist [i][j] = Integer.MAX_VALUE;
            }
        }
        dij(readInt());
        int dest = readInt(), min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            if(dist [dest][i] < min){
                min = dist [dest][i];
            }
        }
        System.out.println(min == Integer.MAX_VALUE? -1 : min);
    }
    static class edge implements Comparable <edge>{
        int v, t, h;
        edge(int a, int b, int c){
            v = a;
            t = b;
            h = c;
        }
        public int compareTo(edge e){
            return Integer.compare(t, e.t);
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