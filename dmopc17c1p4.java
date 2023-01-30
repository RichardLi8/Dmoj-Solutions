import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String[] args) throws IOException{
        int n = readInt(), h = readInt();
        long [] dp = new long [h+1];
        for(int i = 0; i < n; i++){
            int v1 = readInt(), w1 = readInt(), v2 = readInt(), w2 = readInt();
            long [] temp = new long [h+1];
            for(int j = h; j >= w1; j--){
                temp [j] = dp [j-w1] + v1;
            }
            for(int j = 0; j <= h; j++){
                if(j >= w2 && temp [j-w2] != 0){
                    temp [j] = Math.max(temp [j], temp [j-w2] + v2);
                }
                dp [j] = Math.max(dp [j], temp [j]);
            }
        }
        System.out.println(dp [h]);
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
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}