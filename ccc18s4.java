import java.io.*;
import java.util.*;
public class HelloWorld {
    static HashMap <Integer, Long> dp = new HashMap();
    static long f(int w){
        if(w <= 2) return 1;
        if(dp.containsKey(w)) return dp.get(w);
        int up = (int) Math.sqrt(w); long ret = 0;
        for(int i = 2; i <= up; i++){
            ret += f(w/i);
        }
        for(int i = up, last = up; i >= 1; i--){
            ret += (w/i - last) * f(i);
            last = w/i;
        }
        dp.put(w, ret);
        return ret;
    }
    public static void main(String[] args) throws IOException{
        int n = readInt();
        System.out.println(f(n));
    }
    static class pair implements Comparable <pair>{
        long x, y;
        pair(long a, long b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Long.compare(y, p.y);
            return Long.compare(x, p.x);
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