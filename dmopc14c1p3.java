import java.io.*;
import java.util.*;
public class HelloWorld {
    static int [] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += readInt();
        }
        int m = readInt();
        for(int i = 0; i < m; i++){
            sum += readInt();
            System.out.printf("%.3f\n", sum*1.0/(i+1+n));
        }
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
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