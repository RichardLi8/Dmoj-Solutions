import java.io.*;
import java.util.*;
public class HelloWorld {
    static int n, bit [];
    static void update(int i){
        for(; i < bit.length; i += i&-i){
            bit [i]++;
        }
    }
    static int query(int i){
        int ret = 0;
        for(; i > 0; i -= i&-i){
            ret += bit [i];
        }
        return ret;
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] a = new pair [n+1]; bit = new int [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = new pair(readInt(), i);
        }
        Arrays.sort(a, 1, n+1);
        int ans = 1;
        for(int i = 1; i <= n; i++){
            update(a [i].y);
            ans = Math.max(ans, i-query(i));
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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