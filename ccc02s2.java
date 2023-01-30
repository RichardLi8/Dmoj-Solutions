import java.io.*;
import java.util.*;
public class HelloWorld {
    static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), d = readInt();
        int whole = n/d;
        n%=d;
        int gcd = gcd(n, d);
        n/=gcd; d/=gcd;
        if(whole != 0 && n != 0){
            System.out.println(whole + " " + n + "/" + d);
        }
        else if(whole != 0 && n == 0){
            System.out.println(whole);
        }
        else if(whole == 0 && n != 0){
            System.out.println(n + "/" + d);
        }
        else if(whole == 0 && n == 0){
            System.out.println(0);
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