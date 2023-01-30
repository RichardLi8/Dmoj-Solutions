import java.io.*;
import java.util.*;
public class HelloWorld {
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] += v;
        }
    }
    static int bit [];
    static int query(int i){
        int sum = 0;
        for(; i > 0; i -= i&-i){
            sum += bit [i];
        }
        return sum;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        bit = new int [n+2];
        pair [] psa = new pair [n+1]; psa [0] = new pair(0, 1);
        for(int i = 1; i <= n; i++){
            int x = 0, c;
            while((c = br.read())!= ' ' && c != '\n'){
                x = x*10+c-'0';
            }
            psa [i] = new pair(x, 1);
        }
        int p = readInt();
        pair sorted [] = new pair [n+1]; sorted [0] = psa [0];
        for(int i = 1; i <= n; i++){
            psa [i].v += psa [i-1].v-p;
            sorted [i] = psa [i];
        }
        Arrays.sort(sorted, (pair a, pair b) -> {return Long.compare(a.v, b.v);});
        int zero = 1;
        for(int i = 1; i <= n; i++){
            if(sorted [i].v == sorted [i-1].v) sorted [i].w = sorted [i-1].w;
            else sorted [i].w = sorted [i-1].w+1;
            if(sorted [i].v == 0) zero = sorted [i].w;
        }
        update(zero, 1);
        long ans = 0;
        for(int i = 1; i <= n; i++){
            ans += query(psa [i].w);
            update(psa [i].w, 1);
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        long v; int w;
        pair(long a, int b){
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