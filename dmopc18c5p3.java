import java.io.*;
import java.util.*;
/**
 *
 * @author richa
 */
public class AFamiliarProblem {

    public static long most(long sums [], long m){
        int count = 0;
        int left = 0;
        int right = 0;
        for(int i = 1; i < sums.length; i++){
            right = i;
            for(int j = left; j < i; j++){
                if(sums[right]-sums[left] < m){
                    if(right-left > count) count = right-left;
                    break;
                }
                left++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException{
        int n = readInt();
        long m = readLong();
        long [] sums = new long [n+1];
        long prev = 0;
        for(int i = 1; i <= n; i++){
            int num = readInt();
            sums [i] = num+prev;
            prev = sums [i];
        }
        System.out.println(most(sums, m));
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