import java.io.*;
import java.util.*;

public class HelloWorld {

    static int[] minlevels, train;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt();
        List <edge> paths [] = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) paths [i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), c = readInt();
            paths [x].add(new edge(y, c));
            paths [y].add(new edge(x, c));
        }
        int danger [] = new int [n+1], dist [] = new int [n+1];
        Arrays.fill(danger, Integer.MAX_VALUE);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist [1] = 0; danger [1] = 0;
        Queue <Integer> q = new LinkedList();
        q.add(1);
        while(!q.isEmpty()){
            int u = q.poll();
            for(edge e : paths [u]){
                int v = e.v, w = e.w;
                if(danger [v] > danger [u] + w){
                    danger [v] = danger [u] + w;
                    dist [v] = dist [u]+1;
                    q.add(v);
                }
                else if(danger [v] == danger [u] + w && dist [v] > dist [u]+1) {
                    dist [v] = dist [u]+1;
                }
            }
        }
        System.out.println((danger [n] != Integer.MAX_VALUE)?(danger [n] + " " + dist [n]):-1);
    }
    static class edge implements Comparable<edge> {
        int v, w;
        public edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
        public int compareTo(edge x) {
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

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
}