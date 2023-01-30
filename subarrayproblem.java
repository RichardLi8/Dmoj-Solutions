import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] a = new int [n];
        int one = 0;
        for(int i = 0; i < n; i++){
            a [i] = readInt();
            if(a [i] == 1) one = i;
        }
        int max = 1, ans = 0, l = one, r = one;
        while(l > 0 || r < n-1){
            if(max == r-l+1) ans++;
            if(l == 0){
                r++;
                max = Math.max(a [r], max);
            }
            else if(r == n-1){
                l--;
                max = Math.max(a [l], max);
            }
            else{
                if(a [l-1] < a [r+1]){
                    l--;
                    max = Math.max(a [l], max);
                }
                else{
                    r++;
                    max = Math.max(a [r], max);
                }
            }
        }
        if(max == r-l+1) ans++;
        System.out.println(ans);
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