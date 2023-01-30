import java.io.*;
import java.util.*;

public class HelloWorld {
    static int n;
    public static void main(String args[])throws IOException{
        n = readInt();
        String s = "";
        System.out.println("total="+solve(s, n, 1));
    }
    public static int solve(String s, int leftover, int min){
        if(!s.equals(""))System.out.println(n+"="+s+leftover);
        int t = 0;
        for(int i = min; leftover-i >= i; i++){
            t+=solve(s+i+"+", leftover-i, i);
            t++;
        }
        return t;
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
}