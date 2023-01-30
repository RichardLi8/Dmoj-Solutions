import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] a = new int [n+2];
        for(int i = 1; i <= n; i++) a [i] = readInt();
        int [] pre = new int [n+1], suf = new int [n+3];
        for(int i = 1; i <= n; i++){
            pre [i] = pre [i-1] + Math.abs(a [i]-a [i-1]);
        }
        for(int i = n+1; i >= 1; i--){
            suf [i] = suf [i+1] + Math.abs(a [i]-a [i-1]);
        }
        for(int i = 1; i <= n; i++){
            System.out.println(pre [i-1] + suf [i+2] + Math.abs(a [i+1]-a [i-1]));
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Integer.compare(y, p.y);
            return Integer.compare(x, p.x);
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