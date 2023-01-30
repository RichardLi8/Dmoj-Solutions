import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt();
        pair [] a = new pair [n];
        long area = 0;
        for(int i = 0; i < n; i++){
            a [i] = new pair(readInt(), readInt());
        }
        for(int i = 0; i < n; i++){
            area += (a[i].x-a[0].x)*(a[(i+1)%n].y-a[0].y)-(a[i].y-a[0].y)*(a[(i+1)%n].x-a[0].x);
        }
        System.out.println((Math.abs(area)+1)/2);
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
        return br.readLine().trim();
    }
}