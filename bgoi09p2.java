import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static boolean vis [];
    static boolean dfs(int u){
        vis [u] = true;
        boolean flag = false;
        for(int v : adj [u]){
            if(!vis [v]) dfs(v);
            else flag = true;
        }
        return flag;
    }
    public static void main(String [] args) throws IOException{
        for(int q = 0; q < 2; q++){
            int n = readInt();
            adj = new ArrayList [n+1];
            for(int i = 1; i <= n; i++){
                adj [i] = new ArrayList();
            }
            for(int i = 1; i <= n; i++){
                int v = readInt();
                adj [v].add(i);
                adj [i].add(v);
            }
            vis = new boolean [n+1];
            int ans = 0;
            for(int i = 1; i <= n; i++){
                if(!vis [i]){
                    dfs(i);
                    ans++;
                }
            }
            System.out.print(ans + " ");
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(x, p.x);
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