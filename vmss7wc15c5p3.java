import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [][] bit = new int [2002][2002];
    static void update(int i, int v, int [] bit){
        for(; i < bit.length; i += i&-i){
            bit [i] += v;
        }
    }
    static int query(int i, int bit []){
        int sum = 0;
        for(; i > 0; i -= i&-i){
            sum += bit [i];
        }
        return sum;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(); long sum = 0; int mod = (int)1e9+7;
        for(int i = 0; i < n; i++){
            int k = readInt();
            if(k == 1){
                int r = readInt(), c = readInt(), x = readInt();
                update(r, x, bit [c+r-1]);
            }
            else{
                int r = readInt(), c = readInt(), x = readInt();
                sum += query(r, bit [c+r-1])-query(r-x-1, bit [c+r-1]);
                sum %= mod;
            }
        }
        System.out.println(sum);
    }        
    static class pair implements Comparable <pair>{
        long v; int i;
        pair(long a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Long.compare(v, p.v);
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