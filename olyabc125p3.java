import java.io.*;
import java.util.*;
public class HelloWorld {
    static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] l = new int [n+1], r = new int [n+2];
        for(int i = 1; i <= n; i++){
            l [i] = r [i] = readInt();
        }
        for(int i = 2; i<= n; i++){
            l [i] = gcd(l [i-1], l [i]);
        }
        for(int i = n-1; i >= 1; i--){
            r [i] = gcd(r [i+1], r [i]);
        }
        int ans = 1;
        for(int i = 1; i <= n; i++){
            ans = Math.max(ans, gcd(l [i-1], r [i+1]));
        }
        ans = Math.max(ans, l [n-1]); ans = Math.max(ans, r [2]);
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Long.compare(v, p.v);
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