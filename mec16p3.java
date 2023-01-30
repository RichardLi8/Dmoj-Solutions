import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String[] args) throws IOException{
        int n = readInt(), t = readInt();
        int [] dp = new int [t+1];
        for(int i = 0; i < n; i++){
            int l = readInt();
            int [] times = new int [l+1], exps = new int [l+1];
            for(int j = 1; j <= l; j++){
                times [j] = times [j-1] + readInt();
                exps [j] = exps [j-1] + readInt();
            }
            for(int k = t; k >= 0; k--){
                for(int j = 1; j <= l; j++){
                    if(times [j] <= k){
                        dp [k] = Math.max(dp [k], dp [k-times [j]] + exps [j]);
                    }
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}