import java.io.*;
import java.util.*;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        int n = readInt(), k = readInt();
        for (int i = 0; i < k; i++) {
            int s = readInt(), t = readInt(), r = readInt();
            double ans = 0;
            ans += (double) n / s;
            if (ans % t == 0) {
                ans += (int) (ans / t - 1) * r;
            } else {
                ans += (int) ans / t * r;
            }
            System.out.printf("%.0f\n", Math.ceil(ans));
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