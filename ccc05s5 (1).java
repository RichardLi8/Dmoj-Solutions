import java.io.*;
import java.math.RoundingMode;
import java.util.*;
import java.text.DecimalFormat;
public class HelloWorld {
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
    static int [] bit;
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] a = new pair [n];
        bit = new int [n+1];
        for(int i = 0; i < n; i++){
            a [i] = new pair(i+1, readInt());
        }
        Arrays.sort(a);
        double ans = 0;
        for(int i = 0; i < n; i++){
            ans += query(a [i].v-1)+1;
            update(a [i].v, 1);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        System.out.println(df.format(ans/n));
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(w == p.w) return -Integer.compare(v, p.v);
            return -Integer.compare(w, p.w);
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