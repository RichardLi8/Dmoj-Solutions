import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        Random r = new Random();
        for(int i = 0; i < n; i++){
            System.out.println(0);
            System.out.flush();
            int b = readInt();
            if(b == 0) continue;
            long a = 1L << b-1;
            long rng = r.nextLong() & ((1L << b-1)-1);
            a |= rng;
            while(true){
                System.out.println(a);
                System.out.flush();
                b = readInt();
                if(b == 0) break;
                b/=2;
                a ^= 1L << b-1;
            }
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