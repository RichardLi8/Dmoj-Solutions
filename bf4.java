import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        String s = br.readLine();
        String t = br.readLine();
        long hash1 = 0, hash2 = 0, p = 1, mod = (int)1e9 + 9;
        for(int i = 0; i < t.length(); i++){
            hash1 = (s.charAt(i) + hash1*131) % mod;
            hash2 = (t.charAt(i) + hash2*131) % mod;
            p = (p*131) % mod;
        }
        if(hash1 == hash2){
            System.out.println(0);
            return;
        }
        for(int i = t.length(); i < s.length(); i++){
            hash1 = (s.charAt(i) + hash1*131) % mod;
            hash1 = ((hash1-s.charAt(i-t.length())*p) % mod + mod) % mod;
            if(hash1 == hash2){
                System.out.println(i-t.length()+1);
                return;
            }
        }
        System.out.println(-1);
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