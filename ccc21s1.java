import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        double [] h = new double [n+1];
        for(int i = 0; i < n+1; i++){
            h [i] = readInt();
        }
        double ans = 0;
        for(int i = 1; i <= n; i++){
            ans += (h[i-1]+h[i])/2 * readDouble();
        }
        System.out.println(ans);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}