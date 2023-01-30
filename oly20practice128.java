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
        int initial = readInt();
        int rounds = readInt();
        int [] players = new int [n+2];
        for(int i = 0; i < rounds; i++){
            int pos = readInt();
            if(pos == 1){
                players [2]--;
                players [n+1]++;
            }
            else if(pos == n){
                players [1]--;
                players [n]++;
            }
            else{
                players [1]--;
                players [pos]++;
                players [pos+1]--;
                players [n+1]++;
            }
        }
        int count = n;
        players [0] += initial;
        for(int i = 1; i <= n; i++){
            players [i] = players [i-1] + players [i];
            if(players [i] <= 0) count--;
        }
        System.out.println(count);
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