import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        String a = next(), b = next();
        String newa = "", newb = "";
        for(int i = a.length()-1; i >= 0; i--){
            newa += a.charAt(i);
        }
        for(int i = b.length()-1; i >= 0; i--){
            newb += b.charAt(i);
        }
        Long one = Long.parseLong(newa), two = Long.parseLong(newb);
        System.out.println(one < two? one : two);
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