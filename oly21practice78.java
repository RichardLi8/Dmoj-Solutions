import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(); int [] h = new int [n];
        for(int i = 0; i < n; i++){
            h [i] = readInt();
        }
        long ans = Long.MAX_VALUE;
        for(int i = -100; i <= 100; i++){
            long cur = 0;
            for(int j = 0; j < n; j++){
                cur += (h[j]-i)*(h[j]-i);
            }
            ans = Math.min(ans, cur);
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y == p.y) return Integer.compare(x, p.x);
            return -Integer.compare(y, p.y);
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