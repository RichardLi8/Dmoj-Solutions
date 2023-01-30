import java.io.*;
import java.util.*;
public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int n = readInt(), m = readInt(), k = readInt();
        int [] teams = new int [n];
        for(int i = 0; i < n; i++) teams [i] = readInt();
        int scores [] = new int [m+1];
        for(int i = 0; i < m+1; i++) scores [i] = readInt();
        int dp [] = new int [k+1];
        for(int i = 0; i < n; i++){
            for(int j = k; j >= 0; j--){
                for(int a = 0; a <= k && teams [i] + a <= m; a++){
                    int v = scores [a+teams[i]], w = a;
                    if(j >= w){
                        dp [j] = Math.max(dp [j], dp [j-w] + v);
                    }
                }
            }
        }
        System.out.println(dp [k]);
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