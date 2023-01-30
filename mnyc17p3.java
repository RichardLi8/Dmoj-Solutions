import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        String a = next(), b = next();
        long hash1 = 0, hash2 = 0, p = 1, mod = (int)1e9 + 9;
        int max = 0, len = Math.min(a.length(), b.length());
        for(int i = 0; i < len; i++){
            hash1 = (a.charAt(a.length()-i-1) + hash1 * 131)%mod;
            hash2 = (b.charAt(i) * p + hash2) % mod;
            p = (p * 131)%mod;
            if(hash1 == hash2) max = i+1;
        }
        System.out.println(a + b.substring(max));
    }
    static class pair{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
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