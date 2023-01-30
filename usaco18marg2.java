import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> topo = new ArrayList();
    static boolean check(int k, List <Integer> [] order){
        List <Integer> adj [] = new ArrayList [n+1]; int [] in = new int [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 1; i <= k; i++){
            int st = order [i].get(0);
            for(int j = 1; j < order [i].size(); j++){
                adj [st].add(order [i].get(j));
                in [order [i].get(j)]++;
                st = order [i].get(j);
            }
        }
        PriorityQueue <Integer> pq = new PriorityQueue(); topo.clear();
        for(int i = 1; i <= n; i++){
            if(in [i] == 0){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            int u = pq.poll();
            topo.add(u);
            for(int v : adj [u]){
                in [v]--;
                if(in [v] == 0) pq.add(v);
            }
        }
        return topo.size() == n;
    }
    static int n;
    public static void main(String [] args) throws IOException{
        n = readInt(); int m = readInt();
        List <Integer> [] order = new ArrayList [m+1];
        for(int i = 1; i <= m; i++){
            int k = readInt();
            order [i] = new ArrayList();
            for(int j = 0; j < k; j++){
                order [i].add(readInt());
            }
        }
        int l = 1, r = m;
        while(l <= r){
            int mid = (l+r)/2;
            if(check(mid, order)){
                l = mid+1;
            }
            else r = mid-1;
        }
        check(r, order);
        for(int v : topo){
            System.out.print(v + " ");
        }
        System.out.println();
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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
        return br.readLine();
    }
}