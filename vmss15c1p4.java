import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int t = readInt(), n = readInt(), m = readInt(), g = readInt();
        int [] stores = new int [g];
        for(int i = 0; i < g; i++) stores [i] = readInt();
        List <edge> roads [] = new ArrayList [n+1];
        for(int i = 0; i <= n; i++) roads [i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            roads [readInt()].add(new edge(readInt(), readInt()));
        }
        int dist [] = dijkstra(roads);
        int ans = 0;
        for(int i = 0; i < stores.length; i++){
            if(dist [stores [i]] < t) ans++;
        }
        System.out.println(ans);
    }
    static int [] dijkstra(List <edge> roads []){
        int [] dist = new int [roads.length];
        boolean visited [] = new boolean [roads.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist [0] = 0;
        int u = 0;
        while(u != -1){
            visited [u] = true;
            for(edge e : roads [u]){
                if(!visited [e.v] && dist [e.v] > dist [u] + e.c){
                    dist [e.v] = dist [u] + e.c;
                }
            }
            int min = Integer.MAX_VALUE;
            u = -1;
            for(int i = 0; i < dist.length; i++){
                if(dist [i] < min && !visited [i]){
                    u = i;
                    min = dist [i];
                }
            }
        }
        return dist;
    }
    static class edge{
        int v;
        int c;
        public edge(int v, int c){
            this.v = v;
            this.c = c;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}