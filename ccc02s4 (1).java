import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int m = readInt(), n = readInt();
        int [] speeds = new int [n+1]; String names [] = new String [n+1];
        for(int i = 1; i <= n; i++){
            names [i] = next();
            speeds [i] = readInt();
        }
        int dp [] = new int [n+1];
        String dpname [] = new String [n+1];
        dpname [0] = "";
        for(int i = 1; i <= n; i++){
            int speed = 0; String name = "";
            dp [i] = Integer.MAX_VALUE;
            dpname [i] = "";
            for(int j = i; j > 0 && j > i-m; j--){
                speed = Math.max(speed, speeds [j]);
                name += names [j] + " ";
                if(dp [i] > dp [j-1] + speed){
                    dp [i] = dp [j-1] + speed;
                    dpname [i] = dpname [j-1] + "\n" + name;
                }
            }
        }
        System.out.println("Total Time: " + dp [n]);
        System.out.println(dpname [n]);
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