import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), k = readInt(), m = (int)10e6+1;
        int psa [] = new int [m];
        for(int i = 1; i <= n; i++){
            int ppl = readInt(), loc = readInt();
            psa [loc] = ppl;
        }
        for(int i = 1; i < m; i++){
            psa [i] += psa [i-1];
        }
        long ans = psa [k*2];
        for(int i = k*2+1; i < m-k; i++){
            ans = Math.max(psa [i]-psa [i-k*2-1], ans);
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}