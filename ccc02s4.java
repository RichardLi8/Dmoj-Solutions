import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), q = readInt();
        int [] speed = new int [q+1]; String [] name = new String [q+1];
        for(int i = 1; i <= q; i++){
            name [i] = next();
            speed [i] = readInt();
        }
        int dp [] = new int [q+1];
        String dpname [] = new String [q+1];
        dpname [0] = "";
        for(int i = 1; i <= q; i++){
            dp [i] = (int)1e9;
            int time = Integer.MIN_VALUE;
            String names = "";
            for(int j = 0; j < n && i-j > 0; j++){
                time = Math.max(time, speed [i-j]);
                names += name [i-j] + " ";
                if(dp [i] > dp [i-j-1] + time){
                    dp [i] = dp [i-j-1] + time;
                    dpname [i] = dpname [i-j-1] + names;
                }
            }
            dpname [i] += "\n";
        }
        System.out.println("Total Time: " + dp [q]);
        System.out.println(dpname [q]);
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