import java.io.*;
import java.util.*;
public class HelloWorld {
    static int n;
    static List <pair> adj [];
    public static void main(String [] args) throws IOException{
        n = readInt(); int m = readInt(); adj = new List [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), w = readInt();
            adj [x].add(new pair(y, w));
            adj [y].add(new pair(x, w));
        }
        int [] dist = new int [n+1]; dist [1] = Integer.MAX_VALUE;
        boolean [] inqueue = new boolean [n+1];
        Queue <Integer> q = new LinkedList(); q.add(1);
        while(!q.isEmpty()){
            int u = q.poll();
            inqueue [u] = false;
            for(pair p : adj [u]){
                int v = p.v, w = p.w;
                if(dist [v] < Math.min(dist [u], w)){
                    dist [v] = Math.min(dist [u], w);
                    if(!inqueue [v]) q.add(v);
                }
            }
        }
        dist [1] = 0;
        for(int i = 1; i <= n; i++){
            System.out.println(dist [i]);
        }
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(v, p.v);
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