import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] bit;
    static void update(int i, int v){
        for(; i < bit.length; i += (i&-i)){
            bit [i] += v;
        }
    }
    static int query(int i){
        int sum = 0;
        for(; i > 0; i -= (i&-i)){
            sum += bit [i];
        }
        return sum;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        bit = new int [n+1];
        long ans = 0;
        for(int i = 0; i < n; i++){
            int a = readInt();
            int more = i-query (a), less = query(a);
            ans += Math.min(more, less);
            update(a, 1);
        }
        System.out.println(ans);
    }        
    static class pair implements Comparable <pair>{
        int v; double w;
        pair(int a, double b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Double.compare(w, p.w);
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