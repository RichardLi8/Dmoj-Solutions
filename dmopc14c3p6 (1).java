import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), t = readInt();
        int dp [] = new int [t+1];
        for(int i = 0; i < n; i++){
            int pp = readInt(), pv = readInt();
            int ap = readInt(), av = readInt();
            int gp = readInt(), gv = readInt();
            for(int j = t; j >= pp; j--){
                if(j >= pp){
                    dp [j] = Math.max(dp [j], dp [j-pp] + pv);
                }
                if(j >= ap){
                    dp [j] = Math.max(dp [j], dp [j-ap] + av);
                }
                if(j >= gp){
                    dp [j] = Math.max(dp [j], dp [j-gp] + gv);
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