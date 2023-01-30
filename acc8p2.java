import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int t = readInt();
        for(int q = 0; q < t; q++){
            int n = readInt(), k = readInt(); long cnt = 0, ans = 0;
            for(int i = 0; i < n; i++){
                cnt += readInt();
                if(cnt >= k) {
                    cnt = 0;
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }        
    static class pair implements Comparable <pair>{
        long v; int i;
        pair(long a, int b){
            v = a;
            i = b;
        }
        public int compareTo(pair p){
            return Long.compare(v, p.v);
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