import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), d = readInt();
        int [] station = new int [n+1];
        List <Integer> adj [] = new ArrayList [n+1]; int [] dist = new int [n+1];
        for(int i = 1; i <= n; i++) {
            adj [i] = new ArrayList();
            dist [i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt();
            adj [y].add(x);
        }
        dist [n] = 0;
        Queue <Integer> q = new LinkedList(); q.add(n);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj [u]){
                if(dist [v] > dist [u] + 1){
                    dist [v] = dist [u] + 1;
                    q.add(v);
                }
            }
        }
        int cost [] = new int [n+1];
        TreeSet <pair> min = new TreeSet();
        for(int i = 1; i <= n; i++){
            station [i] = readInt();
            if(dist [station [i]] == Integer.MAX_VALUE){
                min.add(new pair(station [i], Integer.MAX_VALUE));
                cost [station [i]] = Integer.MAX_VALUE;
            }
            else{
                cost [station [i]] = i-1 + dist [station [i]];
                min.add(new pair(station [i], cost [station [i]]));
            }
        }
        for(int i = 0; i < d; i++){
            int x = readInt(), y = readInt();
            if(dist [station [x]] != Integer.MAX_VALUE){
                min.remove(new pair(station [x], cost [station [x]]));
                cost [station [x]] = y-1 + dist [station [x]];
                min.add(new pair(station [x], cost [station [x]]));
            }
            if(dist [station [y]] != Integer.MAX_VALUE){
                min.remove(new pair(station [y], cost [station [y]]));
                cost [station [y]] = x-1 + dist [station [y]];
                min.add(new pair(station [y], cost [station [y]]));
            }
            int temp = station [x];
            station [x] = station [y];
            station [y] = temp;
            System.out.println(min.first().w);
        }
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(w == p.w) return Integer.compare(v, p.v);
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
}