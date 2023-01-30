import java.io.*;
import java.util.*;
public class HelloWorld {
    static long [] bit;
    static void update(int i, long v){
        for(; i < bit.length; i += (i&-i)){
            bit [i] += v;
        }
    }
    static long query(int i){
        long sum = 0;
        for(; i > 0; i -= (i&-i)){
            sum += bit [i];
        }
        return sum;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        bit = new long [n+1];
        long a [] = new long [n];
        pair [] sorted = new pair [n];
        for(int i = 0; i < n; i++){
            a [i] = readInt();
            sorted [i] = new pair(a [i], i+1);
            update(i+1, a [i]);
        }
        int idx = 0;
        q queries [] = new q [q];
        long [] ans = new long [q];
        for(int i = 0; i < q; i++){
            queries [i] = new q(readInt(), readInt(), readInt(), i);
        }
        Arrays.sort(queries); Arrays.sort(sorted);
        for(int i = 0; i < q; i++){
            int l = queries [i].l, r = queries [i].r, k = queries [i].k, id = queries [i].i;
            for(; idx < n; idx++){
                if(sorted [idx].v < k){
                    update(sorted [idx].i, -2*sorted [idx].v);
                }
                else break;
            }
            ans [id] = query(r)-query(l-1);
        }
        for(int i = 0; i < q; i++){
            System.out.println(ans [i]);
        }
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
    static class q implements Comparable <q>{
        int l, r, k, i;
        q(int a, int b, int c, int d){
            l = a;
            r = b;
            k = c;
            i = d;
        }
        public int compareTo(q x){
            return Integer.compare(k, x.k);
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