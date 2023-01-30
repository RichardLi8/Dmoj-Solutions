import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), ans = readInt();
        String s = br.readLine();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'o') ans++;
            else{
                ans = Math.max(ans-1, 0);
            }
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