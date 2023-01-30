import java.io.*;
import java.util.*;
public class HelloWorld {
    static long f(long a, long b, long c, long x){
        return a*x*x + b*x + c;
    }
    static void recover(long d [], int t){
        for(int i = 1; i <= t; i++){
            d [i] += d [i-1];
        }
    }
    public static void main(String [] args) throws IOException{
        int n = readInt(), t = readInt();
        long [] d0 = new long [t+3], d1 = new long [t+3], d2 = new long [t+3];
        //d0 -> normal, d1 -> second diff, d2 -> third diff
        for(int i = 0; i < n; i++){
            int l = readInt(), r = readInt(); long a = readInt(), b = readInt(), c = readInt();
            if(r-l+1>=3){
                d1 [l] += c; d1 [l+1] += f(a,b,c,1)-2*c; d1 [r+1] -= f(a,b,c,r-l)*2-f(a,b,c,r-l-1); d1 [r+2] += f(a,b,c,r-l);
                d2 [l+2] += 2*a; d2 [r+1] -= 2*a;
            }
            else if(r-l+1 == 2){
                d0 [l] += c; d0 [l+1] += f(a,b,c,1);
            }
            else if(r-l+1 == 1){
                d0 [l] += c;
            }
        }
        for(int i = 1; i <= t; i++){
            d2 [i] += d2 [i-1];
            d1 [i] += d2 [i];
        }
        for(int i = 0; i < 2; i++){
            recover(d1, t);
        }
        for(int i = 1; i <= t; i++){
            System.out.print(d1 [i] + d0 [i] + " ");
        }
        System.out.println();
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