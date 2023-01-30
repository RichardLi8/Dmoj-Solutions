import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), h = readInt(), p = readInt();
        long [] a = new long [n+1]; long sum = 0;
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
            sum += a [i];
        }
        long ans = sum*p;
        Arrays.sort(a);
        for(int i = 1; i <= n; i++){
            long one = h, two = (long)(n-i+1) * p;
            if(one <= two){
                ans -= (two-one)*(a [i]-a[i-1]);
            }
            else break;
        }
        System.out.println(ans);
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