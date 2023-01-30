import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] fr = new int [n+1], eng = new int [n+1];
        int [] nofr = new int [n+1], onefr = new int [n+1], twofr = new int [n+1];
        for(int i = 1; i <= n; i++) fr [i] = readInt();
        for(int i = 1; i <= n; i++) eng [i] = readInt();
        for(int i = 1; i <= n; i++){
            nofr [i] = Math.max(nofr [i-1] + eng [i], onefr[i-1] + eng [i]);
            onefr [i] = nofr [i-1] + fr [i];
            twofr [i] = onefr [i-1] + fr [i];
            nofr [i] = Math.max(nofr[i], twofr [i-1] + eng [i]);
        }
        System.out.println(Math.max(nofr [n], Math.max(onefr [n], twofr [n])));
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