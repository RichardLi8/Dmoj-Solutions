import java.io.*;
import java.util.*;
public class HelloWorld {
    static long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String [] args) throws IOException{
        for(int t = readInt(); t > 0; t--){
            String a = next(); int k = readInt();
            int n = Integer.parseInt(a); long pre = (long)Math.pow(10, a.length());
            //p * 10^a + N = cK -> cK - p * 10^x = N -> K * x - 10^a * y = N
            long gcd = gcd(k, pre);
            if(n%gcd == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static class pair implements Comparable <pair>{
        long v, w;
        pair(long a, long b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Long.compare(p.w, w);
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