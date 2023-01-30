import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] a = new int [n];
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        Arrays.sort(a);
        int [] b = new int [n];
        int idx = 0;
        for(int i = 1; i < n-1; i+=2){
            b [i] = a [idx++];
        }
        idx = n-1;
        for(int i = 2; i < n-1; i+=2){
            b [i] = a [idx--];
        }
        b [0] = a [idx--];
        b [n-1] = a [idx];
        long ans = 0;
        for(int i = 1; i < n; i++){
            ans += Math.abs(b [i]-b [i-1]);
        }
        idx = n-1;
        for(int i = 1; i < n-1; i+=2){
            b [i] = a [idx--];
        }
        idx = 0;
        for(int i = 2; i < n-1; i+=2){
            b [i] = a [idx++];
        }
        b [0] = a [idx++];
        b [n-1] = a [idx];
        long cur = 0;
        for(int i = 1; i < n; i++){
            cur += Math.abs(b [i]-b [i-1]);
        }
        System.out.println(Math.max(ans, cur));
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