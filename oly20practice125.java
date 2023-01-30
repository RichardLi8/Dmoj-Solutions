import java.io.*;
import java.util.*;

/**
 *
 * @author richa
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int max = readInt();
        int happiest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cost = readInt();
            int happy = readInt();
            if (cost <= max && happiest < happy) {
                happiest = happy;
            }
        }
        System.out.println(happiest);
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

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}