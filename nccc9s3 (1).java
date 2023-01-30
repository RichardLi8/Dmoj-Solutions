import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        char [] a = new char [2*n];
        String s = br.readLine();
        for(int i = 0; i < 2*n; i++){
            a [i] = s.charAt(i);
        }
        long ans = 0;
        int cnt = 0;
        for(int i = 0; i < 2*n; i++){
            if(a [i] == 'I') cnt++;
            else{
                ans += Math.max(0, cnt-1);
                cnt = 0;
            }
        }
        if(cnt > 0) ans += cnt;
        System.out.println(ans);
    }
    static class pair implements Comparable <pair>{
        int x, y;
        pair(int a, int b){
            x = a;
            y = b;
        }
        public int compareTo(pair p){
            return Integer.compare(y, p.y);
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