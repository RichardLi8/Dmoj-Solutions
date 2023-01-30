import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int m = readInt();
        long a = 12, b = -5, c = 1-m;
        double ans = Math.max((-b + Math.sqrt(b*b-4*a*c))/2/a, (-b - Math.sqrt(b*b-4*a*c))/2/a);
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x != p.x) return Integer.compare(x, p.x);
            return Integer.compare(y, p.y);
        }
    }
    static PrintWriter pr = new PrintWriter(System.out);
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