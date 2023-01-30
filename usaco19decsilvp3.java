import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static int [] p;
    static char [] c;
    static void dfs(int src, int cnt){
        p [src] = cnt;
        for(int v : adj [src]){
            if(p [v] == 0 && c [src] == c [v]) dfs(v, cnt);
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        c = new char [n+1]; String s = readLine();
        adj = new ArrayList [n+1]; p = new int [n+1];
        for(int i = 1; i <= n; i++){
            adj [i] = new ArrayList();
            c [i] = s.charAt(i-1);
        }
        int cnt = 1;
        for(int i = 1; i < n; i++){
            int x = readInt(), y = readInt();
            adj [x].add(y); adj [y].add(x);
        }
        for(int i = 1; i <= n; i++){
            if(p [i] == 0) dfs(i, cnt++);
        }
        for(int i = 0; i < q; i++){
            int x = readInt(), y = readInt();
            char m = readChar();
            if(c [x] == m || p [x] != p [y]) System.out.print(1);
            else System.out.print(0);
        }
    }
    static class pair{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
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