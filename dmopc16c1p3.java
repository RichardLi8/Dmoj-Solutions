import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        double [] nums = new double [n+1], dp = new double [n+1];
        for(int i = 1; i <= n; i++) {
            nums [i] = readInt();
            dp [i] = dp [i-1]+nums[i];
        }
        for(int i = 1; i <= n; i++){
            if(i >= 2){
                double min = Math.min(nums [i-1], nums [i]);
                double max = Math.max(nums [i-1], nums [i]);
                dp [i] = Math.min(dp [i], dp[i-2] + min/2.0 + max);
            }
            if(i >= 3){
                double one = Math.max(nums [i], nums [i-1]);
                double two = Math.max(Math.min(nums [i], nums [i-1]), nums[i-2]);
                dp [i] = Math.min(dp [i], dp [i-3] + one+two);
            }
            dp [i] = Math.min(dp [i], dp [i-1]+nums [i]);
        }
        System.out.printf("%.1f", dp [n]);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}