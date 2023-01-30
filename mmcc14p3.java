import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static int max;
    static int [] depth, parent;
    static pair [] sorted;
    static void dfs(int src, int p){
        depth [src] = depth [p]+1;
        sorted [src] = new pair(src, depth [src]);
        parent [src] = p;
        max = Math.max(max, depth [src]);
        for(int v : adj [src]){
            if(v != p) dfs(v, src);
        }
    }
    static void cover(int src, int cnt, int dist, boolean [] vis, int p){
        if(cnt > dist) return;
        vis [src] = true;
        for(int v : adj [src]){
            if(v != p){
                cover(v, cnt+1, dist, vis, src);
            }
        }
    }
    static int dist(int src, int d){
        if (src == 1 || d == 0) {
            return src;
        }
        return dist(parent [src], d-1);
    }
    static boolean query(int d, int s){
        int cnt = 0;
        boolean [] vis = new boolean [sorted.length];
        for(int i = 1; i < sorted.length; i++){
            if(!vis [sorted [i].x]){
                int node = dist(sorted [i].x, d);
                cover(node, 0, d, vis, -1);
                cnt++;
            }
        }
        return cnt <= s;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), s = readInt();
        adj = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 1; i < n; i++){
            int x = readInt(), y = readInt();
            adj [x].add(y); adj [y].add(x);
        }
        depth = new int [n+1]; sorted = new pair [n+1]; parent = new int [n+1];
        dfs(1, 0);
        Arrays.sort(sorted, 1, n+1);
        int l = 0, r = max-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(!query(mid, s)){
                l = mid+1;
            }
            else r = mid-1;
        }
        System.out.println(l);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(y, p.y);
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