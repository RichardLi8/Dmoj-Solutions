import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        long [] a = new long [n+1];
        for(int i = 1; i <= n; i++){
            a [i] = readInt();
        }
        long h [] = new long [n+2];
        long [] sufinc = new long [n+2];
        h [n] = a [n];
        for(int i = n-1; i >= 1; i--){
            if(h [i+1] > a [i]){
                sufinc [i] = h [i+1] - a [i] + sufinc [i+1];
                h [i] = h [i+1];
            }
            else{
                sufinc [i] = sufinc [i+1];
                h [i] = a [i];
            }
        }
        long ans = sufinc [1];
        long pre = a [1], cnt = 0;
        for(int i = 1; i <= n; i++){
            if(pre > a [i]){
                cnt += pre-a[i];
            }
            else pre = a [i];
            if(pre > h [i+1]){
                ans = Math.min(ans, sufinc [i+1]+cnt);
            }
            else{
                ans = Math.min(ans, sufinc [i+1]+cnt+h[i]-pre+1);
            }
        }
        System.out.println(ans);
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