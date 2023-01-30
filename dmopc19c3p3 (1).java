import java.io.*;
import java.util.*;
public class HelloWorld {
    static void update(int i, int v){
        i+=n+1;
        for(; i < bit.length; i += i&-i){
            bit [i] += v;
        }
    }
    static int bit [];
    static int query(int i){
        i+=n+1;
        int sum = 0;
        for(; i > 0; i -= i&-i){
            sum += bit [i];
        }
        return sum;
    }
    static int n;
    public static void main(String [] args) throws IOException{
        n = readInt();
        bit = new int [2*n+2];
        int [] psa = new int [n+1];
        for(int i = 1; i <= n; i++){
            psa [i] = psa [i-1] + (readInt()==2? -1 : 1);
        }
        long ans = 0;
        update(0, 1);
        for(int i = 1; i <= n; i++){
            ans += query(psa [i]-1);
            update(psa [i], 1);
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
}