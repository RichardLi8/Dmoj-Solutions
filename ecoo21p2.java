import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        String s = br.readLine(); int n = s.length();
        System.out.print(s.charAt(0));
        for(int i = 1; i < n; i++){
            if((s.charAt(i) == 'A' && s.charAt(i-1) == 'A') || (s.charAt(i) != 'A' && s.charAt(i-1) != 'A')){
                System.out.print(" ");
            }
            System.out.print(s.charAt(i));
        }
        System.out.println("");
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