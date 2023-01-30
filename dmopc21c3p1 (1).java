import java.io.*;
import java.util.*;
public class HelloWorld {
    static long [] b = {0, 34324, 324238947, 324343};
    static long test(int i, int j){
        long x = b [i], y = b [j];
        b [i] = x+y;
        b [j] = x-y;
        return b [j];
    }
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long [] a = new long [n+1];
        for(int i = 1; i < n; i+=2){
            System.out.println("? " + (i) + " " + (i+1));
            System.out.flush();
            long diff = readLong();
            System.out.println("? " + (i+1) + " " + (i));
            System.out.flush();
            long y = -readLong()/2;
            a [i] = (diff+y);
            a [i+1] = (y);
        }
        if(n%2 == 1){
            System.out.println("? " + (n) + " " + (n-1));
            System.out.flush();
            a [n] = readLong()+2*a[n-2];
        }
        System.out.print("! ");
        for(int i = 1; i <= n; i++){
            System.out.print(a [i] + (i != n? " " : "\n"));
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return -Integer.compare(x, p.x);
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