import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int t = readInt();
        for(int i = 0; i < t; i++){
            long n = readLong(); long s = readLong();
            long totalsum = (n * (n+1))/2;
            long missing = totalsum - s;
            long r = Math.min(n, missing-1);
            long l = missing-r;
            long ans = (r-l+1)/2;
            System.out.println(ans);
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