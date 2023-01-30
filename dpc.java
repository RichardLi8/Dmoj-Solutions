import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt();
        int [] a = new int [n+1], b = new int [n+1], c = new int [n+1];
        a [1] = readInt(); b [1] = readInt(); c [1] = readInt();
        for(int i = 2; i <= n; i++){
            int A = readInt(), B = readInt(), C = readInt();
            a [i] = A + Math.max(b [i-1], c [i-1]);
            b [i] = B + Math.max(a [i-1], c [i-1]);
            c [i] = C + Math.max(a [i-1], b [i-1]);
        }
        int ans = Math.max(a [n], b [n]); ans = Math.max(ans, c[n]);
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