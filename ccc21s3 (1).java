import java.io.*;
import java.util.*;
public class HelloWorld {
    static long time(int pos, long [] p, long [] s, long [] h){
        long ans = 0;
        for(int i = 0; i < p.length; i++){
            if(pos > p[i]+h[i]){
                ans += (pos-(p[i]+h[i]))*s[i];
            }
            else if(pos < p[i]-h[i]){
                ans += ((p[i]-h[i])-pos)*s[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        int n = readInt();
        long [] p = new long [n], s = new long [n], h = new long [n];
        for(int i = 0; i < n; i++){
            p [i] = readInt();
            s [i] = readInt();
            h [i] = readInt();
        }
        int l = 0, r = (int)1e9;
        while(l < r){
            int mid = (l+r)/2;
            if(time(mid, p, s, h) > time(mid+1, p, s, h)){
                l = mid+1;
            }
            else r = mid;
        }
        System.out.println(time(l, p, s, h));
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