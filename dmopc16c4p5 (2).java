import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(); 
        List <pair> adj [] = new List [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt(), w = readInt();
            adj [x].add(new pair(y, w));
            adj [y].add(new pair(x, w));
        }
        PriorityQueue <pair> pq = new PriorityQueue();
        int [] dist = new int [n+1]; dist [1] = Integer.MAX_VALUE;
        pq.add(new pair(1, Integer.MAX_VALUE));
        while(!pq.isEmpty()){
            pair c = pq.poll();
            if(c.w < dist [c.v]) continue;
            for(pair p : adj [c.v]){
                int dis = Math.min(c.w, p.w);
                if(dist [p.v] < dis){
                    dist [p.v] = dis;
                    pq.add(new pair(p.v, dist [p.v]));
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
            return p.w-w;
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