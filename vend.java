import java.util.*;
import java.io.*;
/**
 *
 * @author richa
 */
public class Main {
    public static void main(String[] args) throws IOException{
        int n = readInt(), d = readInt();
        long [] dp = new long [d+1];
        for(int i = 0; i < n; i++){
            int c1 = readInt(), h1 = readInt(), c2 = readInt(), h2 = readInt();
            int totalc = c1 + c2, totalh = h1 + h2;
            for(int j = totalc; j <= d; j++){
                dp [j] = Math.max(dp [j-totalc] + totalh, dp [j]);
            }
            for(int j = d; j >= c1; j--){
                dp [j] = Math.max(dp [j-c1] + h1, dp [j]);
            }
            for(int j = d; j >= c2; j--){
                dp [j] = Math.max(dp [j-c2] + h2, dp [j]);
            }
        }
        System.out.println(dp [d]);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
}