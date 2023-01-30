import java.io.*;
import java.util.*;
public class HelloWorld {
    static long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String [] args) throws IOException{
        for(int t = readInt(); t > 0; t--){
            long a = readLong(), b = readLong();
            long gcd = gcd(a, b);
            a /= gcd; b /= gcd;
            int five = 0;
            while(b % 5 == 0){
                five++;
                b /= 5;
            }
            int two = 0;
            while((b & 1) == 0){
                two++;
                b >>= 1;
            }
            System.out.println(b == 1? Math.max(two, five) : -1);
        }
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