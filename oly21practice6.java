import java.io.*;
import java.util.*;

public class HelloWorld {
    static int n, m, c;
    static long [] dist;
    static List <pair> adj [];
    public static void main(String [] args) throws IOException{
        n = readInt(); m = readInt(); c = readInt();
        adj = new ArrayList [n+1]; dist = new long [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        long sum = 0;
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), w = readInt();
            adj [x].add(new pair(y, w));
            adj [y].add(new pair(x, w));
            sum+=w;
        }
        dij();
        pair sorted [] = new pair [n];
        for(int i = 1; i <= n; i++){
            sorted [i-1] = new pair(i, dist [i]);
        }
        Arrays.sort(sorted);
        long ans = Long.MAX_VALUE;
        long x = 0; int pointer = 0;
        boolean visited [] = new boolean [n+1];
        while(x*c < ans){
            for(int i = pointer; i < n; i++){
                if(sorted [i].w <= x){
                    int index = sorted [i].v;
                    visited [index] = true;
                    for(pair p : adj [index]){
                        int v = p.v; long w = p.w;
                        if(visited [v]){
                            sum -= w;
                        }
                    }
                    pointer = i+1;
                }
                else break;
            }
            ans = Math.min(ans, c*x+sum);
            x++;
        }
        System.out.println(ans);
    }
    static void dij(){
        PriorityQueue <pair> pq = new PriorityQueue();
        pq.add(new pair(1, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist [1] = 0;
        while(!pq.isEmpty()){
            int u = pq.peek().v; long d = pq.poll().w;
            if(d != dist [u]) continue;
            for(pair p : adj [u]){
                int v = p.v; long w = p.w;
                if(dist [v] > dist [u] + w){
                    dist [v] = dist [u] + w;
                    pq.add(new pair(v, dist [v]));
                }
            }
        }
    }
    static class pair implements Comparable <pair>{
        int v; long w;
        public pair(int v, long w){
            this.v = v;
            this.w = w;
        }
        public int compareTo(pair p){
            return Long.compare(w, p.w);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}