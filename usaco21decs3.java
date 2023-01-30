import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String[] args) throws IOException{
        int n = readInt(), m = readInt();
        long [] freq1 = new long [m+1], freq2 = new long [m+1];
        for(int i = 0; i < n; i++){
            freq1 [readInt()]++;
            freq2 [readInt()]++;
        }
        long [] dif = new long [2*m+2];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= m; j++){
                dif [i+j] += freq1 [i] * freq1[j];
                dif [i+j+1] -= freq2 [i] * freq2 [j];
            }
        }
        System.out.println(dif [0]);
        for(int i = 1; i <= 2*m; i++){
            System.out.println(dif [i]+=dif[i-1]);
        }
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