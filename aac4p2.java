import java.io.*;
import java.util.*;
public class HelloWorld {
    static long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        long [] psa = new long [n+1];
        psa [0] = 1;
        for(int i = 1; i <= n; i++){
            psa [i] = readInt();
            if(psa [i-1] == Integer.MAX_VALUE){
                psa [i] = Integer.MAX_VALUE;
                continue;
            }
            psa [i] = psa [i]*psa [i-1]/gcd(psa [i], psa [i-1]);
            if(psa [i] >= Integer.MAX_VALUE){
                psa [i] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < q; i++){
            int t = readInt();
            if(t%psa [n]==0){
                System.out.println(-1);
                continue;
            }
            int l = 1, r = n;
            while(l <= r){
                int mid = (l+r)/2;
                if(t%psa [mid] != 0){
                    r = mid-1;
                }
                else l = mid+1;
            }
            System.out.println(l);
        }
    }
    static class pair implements Comparable <pair>{
        long x, y;
        pair(int a, int b){
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
        return br.readLine();
    }
}