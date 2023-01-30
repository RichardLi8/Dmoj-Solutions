import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int [] a = new int [n+1], b = new int [n+1];
        for(int i = 1; i <= n; i++) a [i] = a[i-1] + readInt();
        for(int i = 1; i <= n; i++) b [i] = b[i-1] + readInt();
        for(int i = n; i >= 0; i--){
            if(a [i] == b [i]){
                System.out.println(i);
                return;
            }
        }
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
    static String readLine() throws IOException {
        return br.readLine();
    }
}