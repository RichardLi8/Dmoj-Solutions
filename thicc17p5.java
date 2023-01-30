import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int [] a = new int [n];
        for(int i = 0; i < n; i++){
            a [i] = readInt();
        }
        int freq [] = new int [1000001], cnt = 1; freq [a[0]]++;
        long ans = 0;
        for(int l = 0, r = 0; l < n; l++){
            while(r < n-1 && cnt < k){
                if(++freq [a[++r]] == 1) cnt++;
            }
            if(cnt == k) ans += n-r;
            if(--freq [a [l]] == 0) cnt--;
        }
        System.out.println(ans);
    }
    static class pair{
        long v; int i;
        pair(long a, int b){
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