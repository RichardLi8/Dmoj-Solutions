import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int N = readInt(), M = readInt();
        long dp [] = new long [5001];
        for(int i = 0; i < N; i++){
            long num = readInt(), cost = readInt(), value = readInt();
            for(int k = 1; k <= num; k*=2){
                long c = cost * k, v = value*k;
                for(int j = 5000; j >= c; j--){
                    dp [j] = Math.max(dp [j], dp [j-(int)c]+v);
                }
                num -= k;
            }
            if(num > 0){
                long c = cost * num, v = value*num;
                for(int j = 5000; j >= c; j--){
                    dp [j] = Math.max(dp [j], dp [j-(int)c]+v);
                }
            }
        }
        long ans = Long.MIN_VALUE;
        for(int i = 0; i < M; i++){
            int c = readInt(), f = readInt();
            ans = Math.max(ans, dp [c]-f);
        }
        System.out.println(ans);
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