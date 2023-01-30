import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static boolean vis [], cycle [];
    static List <Integer> nodes = new ArrayList();
    public static void dfs(int src){
        vis [src] = true;
        nodes.add(src);
        for(int v : adj [src]){
            if(vis [v]){
                int idx = nodes.size()-1;
                while(true){
                    cycle [nodes.get(idx)] = true;
                    if(nodes.get(idx) == v) break;
                    idx--;
                }
                continue;
            }
            dfs(v);
        }
        vis [src] = false;
        nodes.remove(nodes.size()-1);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        adj = new ArrayList [n+1]; vis = new boolean [n+1]; cycle = new boolean [n+1];
        for(int i = 1; i <= n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < k; i++){
            int x = readInt(), y = readInt(), a = readInt(), b = readInt();
            if(a < b) adj [x].add(y);
            else adj [y].add(x);
        }
        for(int i = 1; i <= n; i++){
            dfs(i);
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(cycle [i]) ans++;
        }
        System.out.println(ans);
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