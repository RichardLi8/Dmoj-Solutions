import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long [] psa = new long [n+1], a = new long [n+1];
        for(int i = 1; i <= n; i++) a [i] = readInt();
        Arrays.sort(a, 1, n+1);
        for(int i = 1; i <= n; i++){
            psa [i] = psa [i-1] + a [i];
        }
        long ans = 0;
        for(int i = 1; i <= n-1; i++){
            ans += (psa [n] - psa [i]) -a [i] * (n-i);
        }
        System.out.println(ans);
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