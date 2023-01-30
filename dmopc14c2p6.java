import java.io.*;
import java.util.*;
public class HelloWorld {
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] += v;
        }
    }
    static int query(int i){
        int sum = 0;
        for(; i > 0; i -= i&-i){
            sum += bit [i];
        }
        return sum;
    }
    static int bit [];
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] sorted = new pair [n]; bit = new int [n+1];
        for(int i = 0; i < n; i++){
            int a = readInt();
            update(i+1, a);
            sorted [i] = new pair(a, i+1);
        }
        Arrays.sort(sorted);
        int q = readInt();
        q [] queries = new q [q];
        for(int i = 0; i < q; i++){
            queries [i] = new q(readInt(), readInt(), readInt(), i);
        }
        Arrays.sort(queries);
        int [] ans = new int [q];
        int idx = 0;
        for(int t = 0; t < q; t++){
            int l = queries [t].l+1, r = queries [t].r+1, k = queries [t].k, i = queries [t].i;
            for(; idx < n; idx++){
                if(sorted [idx].v < k){
                    update(sorted [idx].i, -sorted [idx].v);
                }
                else break;
            }
            ans [i] = query(r)-query(l-1);
        }
        for(int i = 0; i < q; i++) System.out.println(ans [i]);
    }
    static class q implements Comparable <q>{
        int l, r, k, i;
        q(int a, int b, int c, int d){
            l = a;
            r = b;
            k = c;
            i = d;
        }
        public int compareTo(q o){
            return Integer.compare(k, o.k);
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
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