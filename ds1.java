import java.io.*;
import java.util.*;
public class HelloWorld {
    static long query(int idx, long bit []){
        long sum = 0;
        for(int i = idx; i > 0; i-=(i&-i)){
            sum += bit [i];
        }
        return sum;
    }
    static void update(int idx, int v, long [] bit){
        for(int i = idx; i < bit.length; i+=(i&-i)){
            bit [i] += v;
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt();
        long [] bit1 = new long [n+1], bit2 = new long [100001]; int [] a = new int [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
            update(i, a [i], bit1);
            update(a [i], 1, bit2);
        }
        for(int i = 0; i < m; i++){
            char c = next().charAt(0);
            if(c == 'C') {
                int x = readInt(), v = readInt();
                update(x, v-a [x], bit1);
                update(a [x], -1, bit2);
                update(v, 1, bit2);
                a [x] = v;
            }
            else if(c == 'S'){
                int l = readInt(), r = readInt();
                System.out.println(query(r, bit1)-query(l-1, bit1));
            }
            else{
                int v = readInt();
                System.out.println(query(v, bit2));
            }
        }
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