import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class ChocolateDay {

    public static long most(long sums [], long m){
        int count = 0;
        int left = 0;
        int right = 0;
        for(int i = 1; i < sums.length; i++){
            right = i;
            for(int j = left; j < i; j++){
                if(sums[right]-sums[left] <= m){
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
        long f = readLong();
        int nums [] = new int [n+2];
        long [] sums = new long [n+1];
        for(int i = 0; i < f; i++){
            int right = readInt();
            int left = readInt();
            int fill = readInt();
            nums [right] += fill;
            nums [left+1] += -fill;
        }
        for(int i = 1; i <= n; i++){
            nums[i] += nums [i-1];
            sums[i] = nums [i] + sums [i-1];
        }
        int l = readInt();
        System.out.println(most(sums, l));
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