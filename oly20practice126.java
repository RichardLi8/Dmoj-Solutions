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
        int students = readInt();
        int coasters = readInt();
        int allowed [] = new int [(int)10e5 + 2];
        for(int i = 0; i < students; i++){
            int n = readInt();
            allowed [1]++;
            allowed [n+1]--;
        }
        for(int i = 1; i < allowed.length; i++){
            allowed [i] = allowed [i-1] + allowed [i];
        }
        for(int i = 0; i < coasters; i++){
            int n = readInt();
            System.out.println(allowed [n]);
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

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}