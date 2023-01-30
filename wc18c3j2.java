import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] w = new int [n];
        for(int i = 0; i < n; i++){
            int m = readInt();
            if(m <= 100) w [i] = m;
            else w[i] = 0;
        }
        Arrays.sort(w);
        int sum = 0;
        for(int i = n-1; i >= 0 && i > n-3; i--) sum += w[i];
        System.out.println(sum);
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
}