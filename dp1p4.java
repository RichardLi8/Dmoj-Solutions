import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        String s = br.readLine(); int n = s.length();
        int [] dp = new int [n+1], pre = new int [27];
        Arrays.fill(pre, -1);
        dp [0] = 1;
        for(int i = 1; i <= n; i++){
            int c = s.charAt(i-1)-'a';
            dp [i] = dp[i-1]<<1;
            if(pre [c] != -1){
                dp [i]-= dp [pre[c]];
                dp [i] = ((dp [i] + 10007)%10007+10007)%10007;
            }
            pre [c] = i-1;
        }
        System.out.println(dp [n]-1);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            if(y != p.y) return -Integer.compare(y, p.y);
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
}