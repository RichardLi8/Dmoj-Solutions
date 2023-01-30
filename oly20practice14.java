import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        pair [] a = new pair [n+1];
        for(int i = 1; i <= n; i++){
            long ai = readLong(), vi = readInt();
            a [i] = new pair(vi, ai);
        }
        Arrays.sort(a, 1 , n+1);
        long [] psa = new long [n+1];
        long ans = 0, pre = Long.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            psa [i] = psa [i-1] + a [i].v;
            pre = Math.min(pre, psa [i-1] - a [i].w);
            ans = Math.max(ans, psa [i]-a [i].w-pre);
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
            return Long.compare(w, p.w);
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