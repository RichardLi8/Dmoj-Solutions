import java.io.*;
import java.util.*;

public class HelloWorld {
    public static boolean prime(int n){
        for(int i = 3; i <= (int)Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        int n = readInt();
        for(int i = 0; i < n; i++){
            int k = readInt();
            int l = 3;
            int r = k*2-3;
            while(true){
                if(prime(l) && prime(r)) break;
                l+=2;
                r-=2;
            }
            System.out.println(l + " " + r);
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