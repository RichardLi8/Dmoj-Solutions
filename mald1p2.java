import java.io.*;
import java.util.*;
public class HelloWorld {
    static void ans(long a){
        if(a > 100) System.out.println("sus");
        else if(a == 100) System.out.println("average");
        else if(a >= 98) System.out.println("below average");
        else if(a >= 95) System.out.println("can't eat dinner");
        else if(a >= 90) System.out.println("don't come home");
        else System.out.println("find a new home");
    }
    public static void main(String[] args) throws IOException{
        int n = readInt();
        for(int i = 0; i < n; i++){
            long t = readLong(), g = readLong();
            ans((long)Math.ceil((double)t/g*100));
        }
    }
    static class cmp implements Comparator <Integer>{
        public int compare(Integer a, Integer b){
            return 0;
        }
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