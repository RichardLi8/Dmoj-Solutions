import java.io.*;
import java.util.*;

public class HelloWorld {
    public static void main(String [] args) throws IOException{
        int t = readInt();
        for(int q = 0; q < t; q++){
            int n = readInt(), k = readInt(), w = readInt();
            int psa [] = new int [n+1];
            for(int i = 1; i <= n; i++) psa [i] = psa [i-1]+readInt();
            int dp [][] = new int [k+1][n+1];
            for(int i = 1; i <= k; i++){
                for(int j = 1; j <= n; j++){
                    if(j <= w) dp [i][j] = psa [j];
                    else{
                        dp [i][j] = Math.max(dp [i][j-1], dp [i-1][j-w] + psa [j] - psa [j-w]);
                    }
                }
            }
            System.out.println(dp [k][n]);
        }
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