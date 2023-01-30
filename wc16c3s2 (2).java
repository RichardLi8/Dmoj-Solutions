import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <pair> adj [];
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        adj = new ArrayList [n+1]; int [] time = new int [n+1];
        for(int i = 1; i <= n; i++){
            adj [i] = new ArrayList();
            time [i] = readInt();
        }
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), w = readInt();
            adj [x].add(new pair(y, w));
            adj [y].add(new pair(x, w));
        }
        PriorityQueue <pair> pq = new PriorityQueue();
        int [] min = new int [n+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        pq.add(new pair(1, 1)); min [1] = 1;
        while(!pq.isEmpty()){
            int u = pq.peek().v, d = pq.poll().w;
            if(min [u] != d) continue;
            for(pair p : adj [u]){
                int v = p.v, w = p.w;
                if(min [v] > Math.max(w, min [u])){
                    min [v] = Math.max(w, min [u]);
                    pq.add(new pair(v, min [v]));
                }
            }
        }
        pair [] order = new pair [n+1];
        for(int i = 1; i <= n; i++){
            order [i] = new pair(i, min [i]);
        }
        Arrays.sort(order, 1, n);
        int gym = time [order [1].v], cur = 1, goal = min [n]; long ans = 0;
        if(goal == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        for(int i = 2; i <= n; i++){
            int dest = Math.min(goal, order [i].w);
            ans += (dest-cur)*(long) gym;
            cur = dest;
            gym = Math.min(gym, time[order [i].v]);
            if(cur == goal) break;
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(v == p.v) return Integer.compare(w, p.w);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}