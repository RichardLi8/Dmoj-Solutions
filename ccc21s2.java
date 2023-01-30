import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int m = readInt(), n = readInt(), k = readInt();
        int [] r = new int [m+1], c = new int [n+1];
        for(int i = 0; i < k; i++){
            String s = next();
            if(s.equals("R")){
                r [readInt()]++;
            }
            else{
                c [readInt()]++;
            }
        }
        int odd = 0;
        for(int i = 1; i <= n; i++){
            if(c [i] % 2 == 1) odd++;
        }
        int ans = 0;
        for(int i = 1; i <= m; i++){
            if(r [i] % 2 == 0) ans+=odd;
            else ans+= (n-odd);
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