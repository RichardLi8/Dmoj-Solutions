import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static Set <Integer> pho = new HashSet <Integer>();
    static Queue <pair> remove = new LinkedList();
    static int start, max = 0;
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        int src = 0;
        for(int i = 0; i < m; i++){
            src = readInt();
            pho.add(src);
        }
        adj = new ArrayList [n];
        for(int i = 0; i < n; i++) adj [i] = new ArrayList();
        for(int i = 0; i < n-1; i++){
            int x = readInt(), y = readInt();
            adj [x].add(y);
            adj [y].add(x);
        }
        prune(new boolean [n], src);
        int leftover = n-1-remove.size();
        while(!remove.isEmpty()){
            pair p = remove.poll();
            Integer u = p.u, v = p.v;
            adj [u].remove(v);
            adj [v].remove(u);
        }
        dfs(new boolean [n], src, 0);
        max = 0;
        dfs(new boolean [n], start, 0);
        System.out.println(2 * (leftover) - max);
    }
    static void dfs(boolean visited [], int src, int dist){
        visited [src] = true;
        if(dist > max){
            max = dist;
            start = src;
        }
        for(Integer v : adj [src]){
            if(!visited [v]){
                dfs(visited, v, dist+1);
            }
        }
    }
    static boolean prune(boolean visited [], Integer src){
        visited [src] = true;
        boolean valid = pho.contains(src);
        for(Integer v : adj [src]){
            if(!visited [v]){
                if(!prune(visited, v)){
                    remove.add(new pair(src, v));
                }
                else valid = true;
            }
        }
        return valid;
    }
    static class pair{
        int u, v;
        public pair(int a, int b){
            u = a;
            v = b;
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