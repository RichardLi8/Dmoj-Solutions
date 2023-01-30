import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt();
        int psamod [] = new int [n+1];
        int lastmod [] = new int [(int)1e6];
        for(int i = 1; i <= n; i++){
            psamod [i] = readInt() + psamod[i-1];
            psamod [i] %= k;
            lastmod [psamod [i]] = Math.max(lastmod [psamod[i]], i);
        }
        int ans = -1;
        for(int i = 0; i <= n; i++){
            ans = Math.max(ans, lastmod[psamod [i]]-i);
        }
        System.out.println(ans);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
}