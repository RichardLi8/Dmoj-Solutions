import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        adj = new ArrayList [n+1];
        int [] in = new int [n+1];
        double [] dp = new double [n+1];
        for(int i = 1; i <= n ; i++){
            adj [i] = new ArrayList();
        }
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt();
            adj [x].add(y);
            in [y]++;
        }
        Queue <Integer> q = new ArrayDeque();
        for(int i = 1; i <= n; i++){
            if(in [i] == 0) q.add(i);
        }
        dp [1] = 1;
        while(!q.isEmpty()){
            int u = q.poll();
            double connections = adj [u].size();
            for(int v : adj [u]){
                dp [v] += dp [u]/connections;
                in [v]--;
                if(in [v] == 0) q.add(v);
            }
        }
        for(int i = 1; i <= n; i++){
            if(adj [i].isEmpty()){
                System.out.println(dp [i]);
            }
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return 0;
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