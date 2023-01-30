import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), start = readInt(), end = readInt();
        List <edge> paths [] = new ArrayList [n+1];
        List <edge> revpaths [] = new ArrayList [n+1];
        for(int i = 1; i <= n; i++){
            paths [i] = new ArrayList();
            revpaths [i] = new ArrayList();
        }
        edge [] edges = new edge [m];
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), len = readInt(), cost = readInt();
            paths [x].add(new edge(y, len));
            revpaths [y].add(new edge(x, len));
            edges [i] = new edge(x, y, len, cost);
        }
        int [] dist = spfa(start, paths);
        int [] revdist = spfa(end, revpaths);
        List <pair> roads = new ArrayList();
        for(int i = 0; i < m; i++){
            edge e = edges [i];
            int x = e.src, y = e.des, l = e.len, c = e.cost;
            if(dist [x] != Integer.MAX_VALUE && revdist [y] != Integer.MAX_VALUE){
                roads.add(new pair(dist [x] + revdist [y] + l, c));
            }
        }
        Collections.sort(roads);
        int [] psa = new int [roads.size()+1];
        for(int i = 1; i < psa.length; i++){
            psa [i] = psa [i-1] + roads.get(i-1).cost;
        }
        int q = readInt();
        for(int i = 0; i < q; i++){
            int d = readInt();
            int l = 0, r = roads.size()-1;
            while(l <= r){
                int mid = l + (r-l)/2;
                if(roads.get(mid).dist > d){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            System.out.println(psa[l]);
        }
    }
    static int [] spfa(int src, List <edge> paths []){
        int [] dist = new int [paths.length];
        boolean [] inqueue = new boolean [paths.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist [src] = 0;
        Queue <Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int u = q.poll();
            inqueue [u] = false;
            for(edge e : paths [u]){
                int v = e.des, w = e.len;
                if(dist [v] > dist [u] + w){
                    dist [v] = dist [u] + w;
                    if(!inqueue [v]) {q.add(v); inqueue [v] = true;}
                }
            }
        }
        return dist;
    }
    static class edge {
        int src, des, len, cost;
        public edge(int s, int d, int l, int c) {
            src = s;
            des = d;
            len = l;
            cost = c;
        }
        public edge(int d, int l){
            des = d;
            len = l;
        }
    }
    static class pair implements Comparable <pair>{
        int dist, cost;
        pair(int d, int c){
            dist = d;
            cost = c;
        }
        public int compareTo(pair x){
            return Integer.compare(dist, x.dist);
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