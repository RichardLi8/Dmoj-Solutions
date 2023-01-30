import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int a = readInt(), b = readInt(), c = readInt(), d = readInt();
        if(a < b && c < d) System.out.println("Go to the department store");
        else if(a < b) System.out.println("Go to the grocery store");
        else if(c < d) System.out.println("Go to the pharmacy");
        else System.out.println("Stay home");
    }
    static class pair{
        long v; int i;
        pair(long a, int b){
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