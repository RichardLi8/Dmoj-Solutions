import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        char nums  [] = next().toCharArray();
        int ans = 0;
        for(int i = n-1; i >= 0; i--){
            if((ans + nums [i])%2 == 1) ans++;
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
}