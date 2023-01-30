import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        List <edge> paths [] = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) paths [i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), c = readInt();
            paths [x].add(new edge(y, c));
            paths [y].add(new edge(x, c));
        }
        int dist [] = dijkstra(n, paths);
        System.out.println("0");
        for(int i = 2; i <= n; i++){
            System.out.println(dist [i]);
        }
    }
    public static int[] dijkstra(int goal, List <edge> [] paths){
        int dist [] = new int [paths.length];
        dist [1] = Integer.MAX_VALUE;
        Queue <Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int u = q.poll();
            for(edge e : paths[u]){
                if(dist [e.goal] < Math.min(dist [u], e.cost)){
                    dist [e.goal] = Math.min(dist [u], e.cost);
                    q.add(e.goal);
                }
            }
        }
        return dist;
    }
    static class edge{
        int goal;
        int cost;
        public edge(int g, int c){
            goal = g;
            cost = c;
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