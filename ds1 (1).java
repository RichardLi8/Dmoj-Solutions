import java.io.*;
import java.util.*;
public class HelloWorld {
    static long [] bit1, bit2;
    static void update(long [] bit, int i, int v){
        for(; i < bit.length; i += i & -i){
            bit [i] += v;
        }
    }
    static long query(long [] bit, int i){
        long ret = 0;
        for(; i > 0; i -= i&-i){
            ret += bit [i];
        }
        return ret;
    }
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        int [] a = new int [n+1];
        bit1 = new long [n+1]; bit2 = new long [100001];
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
            update(bit1, i, a [i]);
            update(bit2, a [i], 1);
        }
        for(int i = 0; i < m; i++){
            char c = readChar();
            if(c == 'C'){
                int x = readInt(), v = readInt();
                update(bit1, x, v-a [x]);
                update(bit2, a [x], -1);
                update(bit2, v, 1);
                a [x] = v;
            }
            else if(c == 'S'){
                int l = readInt(), r = readInt();
                System.out.println(query(bit1, r) - query(bit1, l-1));
            }
            else{
                int v = readInt();
                System.out.println(query(bit2, v));
            }
        }
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return 0;
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