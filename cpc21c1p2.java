import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long [] a = new long [2*n+1], b = new long [2*n+1];
        for(int i = 0; i < 2*n+1; i++){
            a [i] = readLong();
        }
        for(int i = 0; i < 2*n+1; i++){
            b [i] = readLong();
        }
        long x = a [0];
        for(int i = 1; i < 2*n+1; i++){
            x ^= a [i];
        }
        long y = b [0];
        for(int i = 1; i < 2*n+1; i++){
            y ^= b [i];
        }
        long ans = x^y;
        for(int i = 0; i < 2*n+1; i++){
            a [i] ^= ans;
        }
        Arrays.sort(a); Arrays.sort(b);
        for(int i = 0; i < 2*n+1; i++){
            if(a [i] != b [i]){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);
    }
    static class pair{
        int v, i;
        pair(int a, int b){
            v = a;
            i = b;
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