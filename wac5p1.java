import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] freq = new int [1000001];
        for(int i = 0; i < n; i++){
            freq [readInt()]++;
        }
        int ans = 0;
        for(int i = 1000000; i >= 1; i--){
            if(freq [i] == 0) continue;
            ans += freq [i]*i;
            for(int j = i-1; j >= 1; j--){
                freq [j] = Math.max(0, freq [j]-freq [i]);
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