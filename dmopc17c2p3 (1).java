import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static int x, y, min = Integer.MAX_VALUE;
    static boolean [] vis, rabit;
    static int [] dist;
    static boolean dfs(int src){
        vis [src] = true;
        if(rabit [src]) dist [src] = 0;
        boolean ret = false;
        if(src == y) ret = true;
        for(int v : adj [src]){
            if(!vis [v]){
                if(dfs(v)){
                    ret = true;
                }
            }
            dist [src] = Math.min(dist [src], dist [v]+1);
        }
        if(ret) min = Math.min(min, dist [src]);
        return ret;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), r = readInt();
        adj = new ArrayList [n+1]; dist = new int [n+1];
        for(int i = 1; i <= n; i++){
            adj [i] = new ArrayList();
            dist [i] = (int)1e9;
        }
        for(int i = 1; i < n; i++){
            int a = readInt(), b = readInt();
            adj [a].add(b); adj [b].add(a);
        }
        vis = new boolean [n+1]; rabit = new boolean [n+1]; 
        for(int i = 0; i < r; i++) rabit [readInt()] = true;
        x = readInt(); y = readInt();
        dfs(x);
        System.out.println(min);
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
}