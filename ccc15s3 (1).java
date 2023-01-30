import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] p;
    static int find(int x){
        if(p [x] == x) return x;
        return p [x] = find(p [x]);
    }
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt(), ans = 0;
        p = new int [n+1]; for(int i = 1; i <= n; i++) p [i] = i;
        for(int i = 0; i < m; i++){
            int a = readInt();
            int b = find(a);
            if(b != 0){
                p [b] = b-1;
                ans++;
            }
            else break;
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(v == p.v) return Integer.compare(w, p.w);
            return Integer.compare(w, p.w);
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