import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class BobsLightsGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int m = readInt();
        int switches [] = new int [n+2];
        for(int i = 0; i < m; i++){
            switches [readInt()]++;
            switches [readInt()+1]--;
        }
        int count = 0;
        for(int i = 1; i <= n; i++){
            switches [i] += switches [i-1];
            if(switches [i] % 2 == 1) count++;
        }
        System.out.println(count);
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
}