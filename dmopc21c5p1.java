import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt();
        if(n == 1) System.out.println(1);
        else if(n == 2) System.out.println(-1);
        else if(n == 3) System.out.println(-1);
        else if(n == 4) System.out.println(-1);
        else{
            for(int i = 1; i <= n; i+=2){
                System.out.print(i != 5? i + " " : "");
            }
            System.out.print(5 + " " + 4);
            for(int i = 2; i <= n; i+=2){
                System.out.print(i != 4? " " + i : "");
            }
            System.out.println();
        }
    }
    static class pair implements Comparable <pair>{
        long x, y;
        pair(long a, long b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(x == p.x) return Long.compare(y, p.y);
            return Long.compare(x, p.x);
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