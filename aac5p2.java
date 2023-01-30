import java.io.*;
import java.util.*;
public class HelloWorld {
    static long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException{
        int n = readInt();
        long first = 0;
        long [] a = new long [n];
        for(int i = 1; i < n; i++){
            System.out.println("? " + 1 + " " + (i+1));
            System.out.flush();
            a [i] = readLong();
            if(a [i] == -1) System.exit(-1);
            if(first == 0){
                first = a [i];
            }
            else first = gcd(first, a [i]);
        }
        System.out.print("! " + first);
        for(int i = 1; i < n; i++){
            System.out.print(" " + a [i]/first);
        }
        System.out.println();
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            if(v == p.v) return Integer.compare(w, p.w);
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
    static char readChar() throws IOException {
        return next().charAt(0);
    }
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}