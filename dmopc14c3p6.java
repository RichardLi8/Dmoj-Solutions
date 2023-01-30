import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), t = readInt();
        int [] dp = new int [t+1];
        for(int i = 0; i < n; i++){
            int pt = readInt(), pv = readInt(), at = readInt(), av = readInt(), gt = readInt(), gv = readInt();
            for(int j = t; j >= pt; j--){
                if(j >= pt){
                    dp [j] = Math.max(dp [j], dp[j-pt]+pv);
                }
                if(j >= at){
                    dp [j] = Math.max(dp [j], dp[j-at]+av);
                }
                if(j >= gt){
                    dp [j] = Math.max(dp [j], dp[j-gt]+gv);
                }
            }
        }
        System.out.println(dp [t]);
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