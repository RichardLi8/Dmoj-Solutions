import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        boolean [] vis = new boolean [n+1];
        List <Integer> adj [] = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        boolean one = true;
        for(int i = 0; i < m; i++){
            int w = readInt(), l = readInt();
            if(l == 1) one = false;
            adj [l].add(w);
        }
        Queue <Integer> q = new ArrayDeque();
        q.add(1);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj [u]){
                if(!vis [v]){
                    q.add(v);
                    vis [v] = true;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(i == 1 && one){
                System.out.print(1);
            }
            else if(vis [i]) System.out.print(1);
            else System.out.print(0);
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x != p.x) return Integer.compare(x, p.x);
            return Integer.compare(y, p.y);
        }
    }
    static PrintWriter pr = new PrintWriter(System.out);
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