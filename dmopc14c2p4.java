import java.io.*;
import java.util.*;

/**
 *
 * @author richa
 */
public class Deforestation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int n = readInt();
        int trees [] = new int [n];
        for(int i = 0; i < n; i++){
            trees [i] = readInt();
        }
        long mass [] = new long [n+1];
        mass [0] = 0;
        for(int i = 1; i <= n; i++){
            mass [i] = mass [i-1] + trees[i-1];
        }
        int cases = readInt();
        for(int i = 0; i < cases; i++){
            int start = readInt();
            int end = readInt();
            System.out.println(mass[end+1]-mass[start]);
        }
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