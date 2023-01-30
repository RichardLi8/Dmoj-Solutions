import java.io.*;
import java.util.*;

public class HelloWorld {
    
    public static void main(String [] args) throws IOException{
        int n = readInt(), MM = (int)1e5;
        int [] nums = new int [MM+1];
        for(int i = 0; i < n; i++){
            int x = readInt();
            nums [x] +=x;
        }
        int [] dp = new int [MM+2];
        for(int i = 1; i <= MM; i++){
            if(i > 1) dp [i] = Math.max(dp [i-2] + nums [i], dp [i-1]);
            else dp [i] = nums [i];
        }
        System.out.println(dp [MM]);
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