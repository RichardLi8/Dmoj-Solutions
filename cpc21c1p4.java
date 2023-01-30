import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static int [] parent;
    static boolean [] vis;
    static void dfs(int u, int p){
        if(vis [u]) return;
        vis [u] = true;
        parent [u] = p;
        for(int v : adj [u]){
            dfs(v, p);
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        adj = new List [n+1];
        parent = new int [n+1];
        vis = new boolean [n+1];
        for(int i = 1; i <= n; i++){
            adj [i] = new ArrayList();
            parent [i] = i;
        }
        for(int i = 0; i < m; i++){
            int x = readInt(), y = readInt();
            adj [y].add(x);
        }
        for(int i = n; i >= 1; i--){
            dfs(i, i);
        }
        for(int i = n; i >= 1; i--){
            if(parent [i] != i){
                System.out.println(i + " " + parent [i]);
                return;
            }
        }
        System.out.println(-1);
    }
    static class pair{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
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