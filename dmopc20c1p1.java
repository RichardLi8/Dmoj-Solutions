import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        for(int i = 0; i < n; i++){
            boolean m = false, c = false;
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'M') m = true;
                else if(s.charAt(j) == 'C') c = true;
            }
            System.out.println(m & c? "NEGATIVE MARKS" : m|c? "FAIL" : "PASS");
        }
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