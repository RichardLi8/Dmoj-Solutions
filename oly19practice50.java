import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] bit;
    static void update(int i, int v){
        for(; i < bit.length; i += i&-i){
            bit [i] = Math.min(bit [i], v);
        }
    }
    static int query(int i){
        int ret = Integer.MAX_VALUE;
        for(; i > 0; i -= i&-i){
            ret = Math.min(ret, bit [i]);
        }
        return ret;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        triple [] a = new triple [n+1]; bit = new int [n+1];
        for(int i = 1; i <= n; i++){a [i] = new triple(0, 0, 0); bit [i] = Integer.MAX_VALUE;}
        for(int i = 1; i <= n; i++) a [readInt()].f = i;
        for(int i = 1; i <= n; i++) a [readInt()].s = i;
        for(int i = 1; i <= n; i++) a [readInt()].t = i;
        Arrays.sort(a, 1, n+1, (x, y) -> {return -Integer.compare(x.f, y.f);});
        int ans = 0;
        for(int i = n; i >= 1; i--){
            int s = a [i].s;
            int min = query(s-1);
            if(min < a [i].t){
                ans++;
            }
            update(s, a [i].t);
        }
        System.out.println(n-ans);
    }
    static class triple{
        int f, s, t;
        triple(int a, int b, int c){
            f = a;
            s = b;
            t = c;
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
        return br.readLine();
    }
}