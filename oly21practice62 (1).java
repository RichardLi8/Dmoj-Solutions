import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(); long ans = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine(); long cur = 0;
            for(int j = 0; j < s.length(); j++){
                cur += s.charAt(j)-'0';
            }
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        long v, w;
        pair(long a, long b){
            v = a;
            w = b;
        }
        public int compareTo(pair p){
            return Long.compare(p.w, w);
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