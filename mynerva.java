import java.io.*;
import java.util.*;

public class HelloWorld {
    static int [] minbright, maxbright, dist;
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        List <edge> [] paths = new ArrayList [n+1];
        minbright = new int [n+1]; maxbright = new int [n+1]; dist = new int [n+1];
        for(int i = 0; i <= n; i++) paths [i] = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), w = readInt();
            paths [x].add(new edge(y, w));
            paths [y].add(new edge(x, w));
        }
        paths(paths);
        int q = readInt();
        for(int i = 0; i < q; i++){
            int goal = readInt();
            String colour = next();
            if(colour.equals("Black")){
                System.out.println(dist [goal] + " " + minbright [goal]);
            }
            else{
                System.out.println(dist [goal] + " " + maxbright [goal]);
            }
            
        }
    }
    static void paths(List <edge> paths []){
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(minbright, Integer.MAX_VALUE);
        Arrays.fill(maxbright, Integer.MIN_VALUE);
        Queue <Integer> q = new LinkedList<>();
        q.add(1);
        dist [1] = 0;
        minbright [1] = 0;
        maxbright [1] = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(edge e : paths [u]){
                if(dist [e.v] > dist [u] + 1){
                    dist [e.v] = dist [u]+1;
                    q.add(e.v);
                    minbright [e.v] = minbright[u]+e.w;
                    maxbright [e.v] = maxbright[u]+e.w;
                }
                else if(dist [e.v] == dist [u] + 1){
                    if(minbright [e.v] > minbright [u]+e.w) minbright [e.v] = minbright [u]+e.w;
                    if(maxbright [e.v] < maxbright [u]+e.w) maxbright [e.v] = maxbright [u]+e.w;
                }
            }
        }
    }
    static class edge {
        int v, w;
        public edge(int v, int w){
            this.v = v;
            this.w = w;
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}