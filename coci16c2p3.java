import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), ans = 0;
        int [] a = new int [n+1];
        for(int i = 0; i < n; i++) a [i] = readInt();
        int l = 0, lsum = 0, r = n-1, rsum = 0;
        while(l < r){
            lsum += a [l]; rsum += a[r];
            if(lsum == rsum){
                lsum = 0; rsum = 0;
                l++; r--;
            }
            else if(lsum < rsum){
                l++;
                ans++;
                rsum-= a[r];
            }
            else{
                r--;
                ans++;
                lsum -= a[l];
            }
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int v, w;
        pair(int a, int b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Integer.compare(w, p.w);
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