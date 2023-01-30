import java.io.*;
import java.util.*;
public class HelloWorld {
    static List <Integer> adj [];
    static TreeSet <Integer> min [];
    static int [] cnt;
    static void update(int node, int val){
        min [node].add(val);
        while(!min [node].isEmpty() && cnt [node] + 1 == min [node].first()){
            cnt [node]++;
            min [node].pollFirst();
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        adj = new ArrayList [n+1]; min = new TreeSet [n+1]; cnt = new int [n+1];
        for(int i = 1; i <= n; i++){
            adj [i] = new ArrayList();
            min [i] = new TreeSet();
        }
        for(int i = 1; i < n; i++){
            int x = readInt(), y = readInt();
            adj [x].add(y); adj [y].add(x);
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int x = 0;
            for(int v : adj [i]){
                x = Math.max(x, cnt [v]+1);
            }
            if(x == 0) x = 1;
            ans = Math.max(ans, x);
            update(i, x);
            for(int v : adj [i]){
                update(v, x);
            }
        }
        System.out.println(ans);
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