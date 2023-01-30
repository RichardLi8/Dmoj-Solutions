import java.io.*;
import java.util.*;

/**
 *
 * @author richa
 */
public class VictorSMoralDilemma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int trolleys = readInt();
        int days = readInt();
        long [] sums = new long [trolleys+1];
        long prev = 0;
        for(int i = 0; i < trolleys; i++){
            int num = readInt();
            sums [i+1] = num+prev;
            prev = sums [i+1];
        }
        int start = 1;
        int end = trolleys;
        for(int i = 0; i < days; i++){
            int index = readInt();
            long left = sums [start+index-1] - sums [start-1];
            long right = sums [end] - sums [start+index-1];
            if(left < right){
                System.out.println(right);
                end = start + index-1;
            }
            else{
                System.out.println(left);
                start = start+index;
            }
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
    static long readLong () throws IOException {
            return Long.parseLong(next());
    }
}