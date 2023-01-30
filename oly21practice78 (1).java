import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), ans = Integer.MAX_VALUE;
        int [] a = new int [n];
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        for(int y = -100; y <= 100; y++){
            int cur = 0;
            for(int i = 0; i < n; i++){
                cur += (y-a [i])*(y-a[i]);
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