import java.io.*;
import java.util.*;
public class HelloWorld {
    static boolean prime(int n){
        int end = (int) Math.sqrt(n);
        for(int i = 2; i <= end; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        int t = readInt();
        for(int q = 0; q < t; q++){
            int n = readInt();
            if(n == 1) System.out.println(1);
            else if(n <= 3) System.out.println(-1);
            else if(n == 4) System.out.println("3 1 4 2");
            else if(n == 5) System.out.println("3 1 4 2 5");
            else if(n == 6) System.out.println("1 3 5 2 4 6");
            else if(n == 7) System.out.println("3 5 7 2 4 6 1");
            else{
                boolean odd = false;
                if(n%2 == 1){
                    n--;
                    odd = true;
                }
                int x = 0;
                for(x = 2; x <= n; x++){
                    if(prime(x) && prime(n-x)) break;
                }
                int [] a = new int [n + (odd?1:0)];
                for(int i = 0; i < n; i++){
                    a [i] = i*x%n;
                }
                if(odd){
                    a [n] = n;
                    n++;
                }
                for(int i = 0; i < n; i++){
                    System.out.print(a [i]+1 + (i != n-1 ? " " : "\n"));
                }
            }
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